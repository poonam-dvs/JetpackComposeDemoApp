package com.example.jetpackcomposedemoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposedemoapp.data.models.BlogData
import com.example.jetpackcomposedemoapp.presentation.screens.BlogDetailsScreen
import com.example.jetpackcomposedemoapp.presentation.screens.BlogListScreen
import com.example.jetpackcomposedemoapp.presentation.screens.BlogsScreen
import com.example.jetpackcomposedemoapp.presentation.screens.HelpScreen
import com.example.jetpackcomposedemoapp.presentation.screens.HomeMainScreen
import com.example.jetpackcomposedemoapp.presentation.screens.RegisterScreen
import com.example.jetpackcomposedemoapp.presentation.screens.SettingScreen
import com.google.gson.Gson

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

        composable(Screen.HomeMainScreen.route){
            HomeMainScreen(navController)
        }

        composable(Screen.SettingScreen.route){
            SettingScreen()
        }

        composable(Screen.HelpScreen.route){
            HelpScreen()
        }

        composable(Screen.BlogScreen.route) {
            BlogListScreen(navController = navController)
        }

        composable(
            // 1. Defines the route pattern for this destination
            route = Screen.BlogsDetailsScreen.route+"/{blogJson}",
            // 2. Specifies the type of data expected in the placeholder
            arguments = listOf(navArgument("blogJson") { type = NavType.StringType })
        ) { backStackEntry -> // 3. The code to execute when this route is navigated to
            // 4. Extracts the actual JSON string from the navigation arguments
            val blogJson = backStackEntry.arguments?.getString("blogJson")
            // 5. Converts the JSON string back into a BlogData object
            val blog = Gson().fromJson(blogJson, BlogData::class.java)
            // 6. Displays the BlogDetailsScreen, passing the BlogData object to it
            BlogDetailsScreen(blogData = blog, navController = navController)
        }
    }
}
