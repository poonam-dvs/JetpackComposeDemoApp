package com.example.jetpackcomposedemoapp.data.remote

import com.example.jetpackcomposedemoapp.data.models.BlogResponse
import retrofit2.http.GET

interface ApiService {
    @GET("get_blogs.php")
    suspend fun getBlogs(): BlogResponse

}