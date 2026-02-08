package com.example.jetpackcomposedemoapp.data.repository.profile

import com.example.jetpackcomposedemoapp.data.Resource
import com.example.jetpackcomposedemoapp.data.models.BlogResponse
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getBlogs():Flow<Resource<BlogResponse>>

}