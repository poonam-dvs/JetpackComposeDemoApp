package com.example.jetpackcomposedemoapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NotesScreenViewModel: ViewModel() {
    var inputText by mutableStateOf("") //holds TextField value
        private set // Anyone can read inputText but only this class can edit this value

    val textList = mutableStateListOf<String>() //holds list of notes ,mutableStateListOf automatically recomposes LazyColumn

    fun onTextChanged(newText: String) {
        inputText = newText
    }

    fun addText(){
        if(inputText.isNotEmpty()){
            textList.add(inputText)
            inputText = ""
        }
    }
}