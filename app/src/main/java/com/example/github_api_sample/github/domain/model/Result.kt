package com.example.github_api_sample.github.domain.model

sealed class Result<out R>

data class Success<out T>(val value: T) : Result<T>()
data class Failure(val reason: Exception) : Result<Nothing>()
