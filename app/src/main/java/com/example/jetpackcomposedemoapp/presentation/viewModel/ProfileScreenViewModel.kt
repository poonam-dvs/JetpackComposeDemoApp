package com.example.jetpackcomposedemoapp.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemoapp.data.Resource
import com.example.jetpackcomposedemoapp.data.models.BlogData
import com.example.jetpackcomposedemoapp.data.models.BlogResponse
import com.example.jetpackcomposedemoapp.data.repository.profile.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor( private val repository: ProfileRepository):
    ViewModel() {
    private val mutableBlogList =MutableStateFlow<Resource<BlogResponse>?>(value = null)
    val blogList : StateFlow<Resource<BlogResponse>?> get()= mutableBlogList

    private val _selectedBlog = MutableStateFlow<BlogData?>(null) // ✅ Selected Blog
    val selectedBlog: StateFlow<BlogData?> = _selectedBlog

    fun fetchBlog(){
        viewModelScope.launch {
            repository.getBlogs().collect {
                mutableBlogList.value=it
            }
        }
    }

    fun setSelectedBlog(blog: BlogData) { // ✅ Function to set selected blog
        Log.d("TAGViewmOdel", "setSelectedBlog: "+blog)
        _selectedBlog.value = blog
    }
}