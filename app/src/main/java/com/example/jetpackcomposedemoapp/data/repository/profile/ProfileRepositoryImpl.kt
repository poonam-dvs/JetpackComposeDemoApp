package com.example.jetpackcomposedemoapp.data.repository.profile

import com.example.jetpackcomposedemoapp.data.Resource
import com.example.jetpackcomposedemoapp.data.models.BlogResponse
import com.example.jetpackcomposedemoapp.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(private val apiService: ApiService):
    ProfileRepository {
    override suspend fun getBlogs(): Flow<Resource<BlogResponse>> = flow {
        val response = apiService.getBlogs()
        emit(Resource.Success(response))
    }
}