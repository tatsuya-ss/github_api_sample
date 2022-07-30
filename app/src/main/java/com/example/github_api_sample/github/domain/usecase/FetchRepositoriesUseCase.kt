package com.example.github_api_sample.github.domain.usecase

import com.example.github_api_sample.github.data.repository.GitHubRepositoryRepositoryImpl
import com.example.github_api_sample.github.domain.model.Repository
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.repository.GitHubRepositoryRepository
import com.example.github_api_sample.github.domain.repository.GitHubUserRepository

class FetchRepositoriesUseCase(
    private val gitHubRepositoryRepository: GitHubRepositoryRepository = GitHubRepositoryRepositoryImpl()
) {
    suspend fun invoke(name: String, sort: String): Result<List<Repository>> {
        return gitHubRepositoryRepository.fetchRepositories(name, sort)
    }
}