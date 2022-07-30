package com.example.github_api_sample.github.data.repository

import com.example.github_api_sample.github.data.service.CreateService
import com.example.github_api_sample.github.data.service.GitHubService
import com.example.github_api_sample.github.domain.model.*
import com.example.github_api_sample.github.domain.repository.GitHubUserRepository
import java.lang.Exception

class GitHubUserRepositoryImpl(
) : GitHubUserRepository {
    private val service: GitHubService = CreateService().createService()

    override suspend fun fetchUser(userName: String): Result<User> {
        val user = service.fetchUser(userName)
        return if (user.name.isNotBlank()) {
            Success(User(user.name))
        } else {
            Failure(Exception())
        }
    }
}
