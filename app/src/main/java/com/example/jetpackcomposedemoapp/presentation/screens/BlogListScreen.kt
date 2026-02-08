package com.example.jetpackcomposedemoapp.presentation.screens

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposedemoapp.data.Resource
import com.example.jetpackcomposedemoapp.data.models.BlogData
import com.example.jetpackcomposedemoapp.data.models.BlogResponse
import com.example.jetpackcomposedemoapp.presentation.navigation.Screen
import com.example.jetpackcomposedemoapp.presentation.viewModel.ProfileScreenViewModel
import com.example.jetpackcomposedemoapp.utils.HandleApiState
import com.example.jetpackcomposedemoapp.utils.ToolbarWithBackButtonAndTitle
import com.google.gson.Gson
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.collections.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogListScreen(
    navController: NavController,
    viewModel : ProfileScreenViewModel = hiltViewModel()
) {

    var blogResponse by remember { mutableStateOf<BlogResponse?>(null) }
    val apiState by viewModel.blogList.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchBlog()
    }

// HandleApiState
    /*HandleApiState(apiState = viewModel.blogList, // Pass the API state
        showLoader = true, // Enable/disable loader
        navController = navController, onSuccess = { data ->
            blogResponse = data
        }) {*/

        Scaffold(
            topBar = {
                ToolbarWithBackButtonAndTitle("Blogs",
                    onBackClick = { navController.popBackStack() })
            },
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {

                when(val currentState = apiState){
                    is Resource.Loading -> {
                        CircularProgressIndicator()
                    }
                    is Resource.Success -> {
                        val blogList = currentState.data?.data
                        if (!blogList.isNullOrEmpty()) {
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(blogList.size) { index ->
                                    val blogItem = blogList[index]
                                    PostCardTop(blog = blogItem) {
                                        // It's better to pass only the ID, but using JSON works too
                                        val blogJson = Uri.encode(Gson().toJson(blogItem))
                                        navController.navigate(Screen.BlogsDetailsScreen.route + "/$blogJson")
                                    }
                                }
                            }
                        } else {
                            // Handle the case where the API returns an empty list
                            Text("No blogs found.")
                        }
                    }
                    is Resource.Error -> {
                        // Show an error message
                        Text(text = currentState.message ?: "An unknown error occurred.")
                    }

                    else -> {
                        // This handles the initial state before 'Loading'
                        // You can leave it empty or show a placeholder
                    }
                }
                /*LazyColumn(modifier = Modifier.fillMaxSize()) {
                    blogResponse?.data?.let {
                        items(it.size) { index ->
                            PostCardTop(it[index]){
                                viewModel.setSelectedBlog(it[index])
                                val blogJson = Uri.encode(Gson().toJson(it[index]))
                                navController.navigate(Screen.BlogsDetailsScreen.route+"/$blogJson")
                            }
                        }
                    }
                }*/
            }
        }
   // }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogDetailsScreen(
    blogData: BlogData,
    navController: NavController
){
    Scaffold(
        topBar = {
            ToolbarWithBackButtonAndTitle(
                title = blogData!!.title,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = blogData.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))

            Text(
                text = blogData.title,
                style = typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = blogData.description,
                style = typography.labelLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = formatDateTime(blogData.publishedDate),
                style = typography.bodySmall
            )
        }

    }

}

@Composable
fun PostCardTop(blog: BlogData, onClick: () -> Unit) {    // TUTORIAL CONTENT STARTS HERE
    val typography = MaterialTheme.typography
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() }, // Open Details Page
    ) {
        val imageModifier = Modifier
            .heightIn(min = 180.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.large)
        Image(
            painter = rememberAsyncImagePainter(blog.imageUrl),
            // painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/android/nowinandroid/main/docs/images/nia-splash.jpg"),
            contentDescription = null, // decorative
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = blog.title,
            style = typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = blog.description,
            style = typography.labelLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = formatDateTime(blog.publishedDate),
            style = typography.bodySmall
        )
    }
}





@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(input: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val outputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, hh:mm a", Locale.ENGLISH)

    val dateTime = LocalDateTime.parse(input, inputFormatter)
    return dateTime.format(outputFormatter)
}