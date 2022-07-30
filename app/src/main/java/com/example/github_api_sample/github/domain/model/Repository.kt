package com.example.github_api_sample.github.domain.model

import java.io.Serializable

data class Repository(
    val name: String,
    val createdAt: String,
    val htmlUrl: String,
) : Serializable
