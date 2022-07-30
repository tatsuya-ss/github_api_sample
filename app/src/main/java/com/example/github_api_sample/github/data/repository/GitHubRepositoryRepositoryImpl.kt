package com.example.github_api_sample.github.data.repository

import com.example.github_api_sample.github.data.mapper.convertToModel
import com.example.github_api_sample.github.data.service.CreateService
import com.example.github_api_sample.github.data.service.GitHubService
import com.example.github_api_sample.github.domain.model.Failure
import com.example.github_api_sample.github.domain.model.Repository
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.model.Success
import com.example.github_api_sample.github.domain.repository.GitHubRepositoryRepository
import java.lang.Exception

class GitHubRepositoryRepositoryImpl: GitHubRepositoryRepository {
    private val service: GitHubService = CreateService().createService()

    override suspend fun fetchRepositories(
        userName: String,
        sort: String
    ): Result<List<Repository>> {
        val repositories = service.fetchRepositories(userName, sort)
        return if (repositories.isNotEmpty()) {
            Success(repositories.convertToModel())
        } else {
            Failure(Exception())
        }
    }
}