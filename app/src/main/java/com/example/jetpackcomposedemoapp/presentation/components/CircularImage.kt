package com.example.jetpackcomposedemoapp.presentation.components

import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularImage(
    imageRes: Int,
    size: Dp = 100.dp,
    modifier: Modifier = Modifier
){
    Image(
       modifier = modifier
           .size(size)
           .border(2.dp, Color.Gray, CircleShape),
        painter = painterResource(id = imageRes),
        contentDescription = "Circular Image",
        contentScale = ContentScale.Crop
    )
}