package com.example.jetpackcomposedemoapp.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.jetpackcomposedemoapp.R

/*
* NavController must be created once
✔ BottomBar must NOT create NavController
✔ Use launchSingleTop
✔ Use popUpTo for bottom navigation
✔ Use sealed class for routes
* */
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    val items = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Cart,
        BottomNavScreens.Wishlist,
        BottomNavScreens.Profile
    )
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) { // ✅ Set background to White
        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(
                            id = when (screen) {
                                BottomNavScreens.Home -> R.drawable.home
                                BottomNavScreens.Cart -> R.drawable.cart
                                BottomNavScreens.Wishlist -> R.drawable.heart
                                BottomNavScreens.Profile -> R.drawable.avatar
                            }
                        ),
                        contentDescription = screen.route,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(
                            if (isSelected) Color(0xFF1E88E5) else Color.Gray
                        )
                    )
                },
                label = {
                    Text(
                        text = screen.route.replaceFirstChar { it.uppercase() },
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color(0xFF1E88E5) else Color.Gray // ✅ Selected → Primary Color, Unselected → Gray
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = false }
                        launchSingleTop = true //: This important flag tells the NavController, "If the Profile screen is already at the top of the history, don't create a new one. Just reuse it.
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF1E88E5), // ✅ Selected Icon → Primary Color
                    unselectedIconColor = Color.Gray, // ✅ Unselected Icon → Gray
                    selectedTextColor = Color(0xFF1E88E5), // ✅ Selected Text → Primary Color
                    unselectedTextColor = Color.Gray, // ✅ Unselected Text → Gray
                    indicatorColor = Color.White // ✅ Highlight color for selected item circle color

                )
            )
        }
    }

}