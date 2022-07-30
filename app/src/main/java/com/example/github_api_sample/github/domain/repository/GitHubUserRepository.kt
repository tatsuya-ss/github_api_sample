package com.example.github_api_sample.github.domain.repository

import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.model.User

interface GitHubUserRepository {
    suspend fun fetchUser(name: String): Result<User>
}
