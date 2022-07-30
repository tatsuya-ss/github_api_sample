package com.example.github_api_sample.github.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repository(
    @SerializedName("name")
    val name: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("html_url")
    val htmlUrl: String,
): Serializable
