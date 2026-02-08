package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemoapp.presentation.components.Spacer_16dp

@Composable
fun ProfileItem(
    @DrawableRes iconRes: Int,
    title: String,
    subtitle: String? = null,
    showArrow: Boolean = true,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = iconRes),
                contentDescription = "$title Icon"
            )

            Spacer_16dp()

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold
                )

                subtitle?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            if (showArrow)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Arrow Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
        }
    }
    androidx.compose.material3.HorizontalDivider(
        modifier  = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Color(0xFFB3B3B3)
    )
}