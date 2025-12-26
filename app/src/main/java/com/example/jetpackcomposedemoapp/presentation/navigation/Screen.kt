package com.example.jetpackcomposedemoapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val label: String,
    val icon: ImageVector? = null,
) {
    object Home: Screen("home_screen", "Home", Icons.Default.Home)

    object Profile: Screen("profile_screen", "Profile", Icons.Default.Person)

    object Wishlist: Screen("wishlist_screen", "Wishlist", Icons.Default.Favorite)

    object Cart: Screen("cart_screen", "Cart", Icons.Default.ShoppingCart)

    object Register: Screen(route = "register_screen", "Register", Icons.Default.AccountBox)

    object HomeMainScreen: Screen(route = "home_main_screen", "HomeMainScreen")

}