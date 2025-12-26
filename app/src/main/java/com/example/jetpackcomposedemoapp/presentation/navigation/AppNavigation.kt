package com.example.jetpackcomposedemoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemoapp.presentation.screens.HomeMainScreen
import com.example.jetpackcomposedemoapp.presentation.screens.RegisterScreen

@Composable
fun AppNavigation() {
    /*rememberNavController() → create
✔ NavHost → define destinations
✔ navController.navigate() → move screens
✔ popBackStack() → go back
*/
    val navController = rememberNavController() // create
    NavHost(navController = navController, startDestination = Screen.Register.route){
        composable(Screen.Register.route){
            RegisterScreen(navController)
        }
        composable(Screen.Home.route){

        }
        composable(Screen.Profile.route){

        }
        composable(Screen.Wishlist.route){

        }
        composable(Screen.Cart.route){

        }
        composable(Screen.HomeMainScreen.route){
            HomeMainScreen(navController)
        }

    }
}