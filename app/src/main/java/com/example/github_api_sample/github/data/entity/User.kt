package com.example.github_api_sample.github.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("name")
    val name: String,
) : Serializable
