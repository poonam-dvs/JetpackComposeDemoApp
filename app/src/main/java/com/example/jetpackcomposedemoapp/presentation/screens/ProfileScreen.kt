package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposedemoapp.R
import com.example.jetpackcomposedemoapp.presentation.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {
    /*Text(
        text = "ProfileScreen",
        modifier = Modifier.fillMaxSize()
    )*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileItem(
            iconRes = R.drawable.blog,
            title = "Blog",
            subtitle = "blog subtitle"
        ) {
            navHostController.navigate(Screen.BlogScreen.route)
        }
        ProfileItem(
            iconRes = R.drawable.help,
            title = "Help",
            subtitle = "help subtitle"
        ) {
            navHostController.navigate(Screen.HelpScreen.route)
        }
        ProfileItem(
            iconRes = R.drawable.setting,
            title = "Setting",
            subtitle = "setting subtitle"
        ) {
            navHostController.navigate(Screen.SettingScreen.route)
        }
    }

}