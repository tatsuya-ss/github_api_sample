package com.example.github_api_sample.github.data.repository

import com.example.github_api_sample.github.data.service.CreateService
import com.example.github_api_sample.github.data.service.GitHubService
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.model.User
import com.example.github_api_sample.github.domain.repository.GitHubUserRepository
import java.lang.Exception

class GitHubUserRepositoryImpl(
) : GitHubUserRepository {
    private val service: GitHubService = CreateService().createService()

    override suspend fun fetchUser(name: String): Result<User> {
        val user = service.fetchUser(name)
        return if (user.name.isNotBlank()) {
            Result.Success(User(user.name))
        } else {
            Result.Failure(Exception())
        }
    }
}
