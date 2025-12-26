package com.example.jetpackcomposedemoapp.presentation.navigation

sealed class BottomNavScreens(val route: String) {
    object Home : BottomNavScreens("home")
    object Cart : BottomNavScreens("cart")
    object Wishlist : BottomNavScreens("wishlist")
    object Profile : BottomNavScreens("profile")
}