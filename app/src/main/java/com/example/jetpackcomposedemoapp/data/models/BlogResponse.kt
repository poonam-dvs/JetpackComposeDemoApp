package com.example.jetpackcomposedemoapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BlogResponse(
    @SerializedName("data")
    val `data`: List<BlogData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
): Parcelable
