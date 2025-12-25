package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemoapp.R
import com.example.jetpackcomposedemoapp.presentation.components.CircularImage
import com.example.jetpackcomposedemoapp.presentation.components.CustomOutlinedTextField
import com.example.jetpackcomposedemoapp.presentation.components.CustomPasswordField
import com.example.jetpackcomposedemoapp.presentation.components.Spacer_10dp
import com.example.jetpackcomposedemoapp.presentation.components.Spacer_20dp
import com.example.jetpackcomposedemoapp.presentation.components.Spacer_8dp
import com.example.jetpackcomposedemoapp.presentation.components.SubtitleLarge
import com.example.jetpackcomposedemoapp.presentation.components.TitleMedium

@Composable
fun RegisterScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var referCode by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF7F7F7)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularImage(imageRes = R.drawable.logo)

        Spacer_20dp()

        TitleMedium(text = "Register")

        Spacer_8dp()

        SubtitleLarge("Create new account")

        Spacer_20dp()

        // for first name and last name field Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = firstName,
                label = {
                    Text(
                        text = "First Name",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                onValueChange = { firstName },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = true,
                enabled = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person Icon"
                    )
                }
            )

            // for last name
            OutlinedTextField(
                value = lastName,
                label = {
                    Text(
                        text = "Last Name",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                onValueChange = { lastName },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = true,
                enabled = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person Icon"
                    )
                }
            )
        }

        // for email
        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
        )

        Spacer_10dp()

        CustomOutlinedTextField(
            value = referCode,
            onValueChange = { referCode = it },
            label = "Refer Code",
            leadingIcon = Icons.Default.Share,
            keyboardType = KeyboardType.Text
        )

        Spacer_10dp()

        // Password Field with Eye Icon
        CustomPasswordField(
            value = password, onValueChange = { password = it }, iserror = false
        )
        Spacer_10dp()
    }
}