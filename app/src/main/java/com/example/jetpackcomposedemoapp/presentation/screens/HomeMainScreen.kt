package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemoapp.presentation.navigation.BottomNavScreens
import com.example.jetpackcomposedemoapp.presentation.navigation.BottomNavigationBar

@Composable
fun HomeMainScreen(navController: NavHostController) {
    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = bottomNavController, currentDestination)
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = bottomNavController,
            startDestination = BottomNavScreens.Home.route
        ) {
            composable(BottomNavScreens.Home.route) {
                HomeScreen( navHostController = navController)
            }
            composable(BottomNavScreens.Cart.route) {
                CartScreen(navHostController = navController)
            }

            composable(BottomNavScreens.Wishlist.route) {
                WishlistScreen(navHostController = navController)
            }

            composable(BottomNavScreens.Profile.route) {
                ProfileScreen(navHostController = navController)
            }
        }
    }
}