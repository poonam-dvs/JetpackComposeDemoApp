package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {
    Text(
        text = "ProfileScreen",
        modifier = Modifier.fillMaxSize()
    )
}