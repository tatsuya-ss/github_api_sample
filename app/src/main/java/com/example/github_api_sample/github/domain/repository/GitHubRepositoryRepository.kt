package com.example.github_api_sample.github.domain.repository

import com.example.github_api_sample.github.domain.model.Repository
import com.example.github_api_sample.github.domain.model.Result

interface GitHubRepositoryRepository {
    suspend fun fetchRepositories(userName: String, sort: String): Result<List<Repository>>
}