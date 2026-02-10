package com.example.jetpackcomposedemoapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposedemoapp.presentation.viewModel.NotesScreenViewModel

@Composable
fun NotesScreen(
    viewModel: NotesScreenViewModel = viewModel()
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = viewModel.inputText,
            onValueChange = viewModel::onTextChanged,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Enter text") }
        )
        Button(onClick = viewModel::addText,
            modifier = Modifier.fillMaxWidth()) {
            Text("Add Text")
        }
        LazyColumn {
            items(viewModel.textList) {
                Text(it, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
