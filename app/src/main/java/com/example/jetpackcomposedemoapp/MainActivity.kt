package com.example.jetpackcomposedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemoapp.presentation.navigation.AppNavigation
import com.example.jetpackcomposedemoapp.ui.theme.JetpackComposeDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeDemoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                /*   Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    AppNavigation()
                }
                /*val navController = rememberNavController()
                AppNavigation()*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeDemoAppTheme {
        Greeting("Android")
    }
}