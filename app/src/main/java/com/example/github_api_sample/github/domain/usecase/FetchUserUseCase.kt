package com.example.github_api_sample.github.domain.usecase

import com.example.github_api_sample.github.data.repository.GitHubUserRepositoryImpl
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.model.User
import com.example.github_api_sample.github.domain.repository.GitHubUserRepository

class FetchUserUseCase(
    private val gitHubUserRepository: GitHubUserRepository = GitHubUserRepositoryImpl()
) {

    suspend fun invoke(userName: String): Result<User> {
        return gitHubUserRepository.fetchUser(userName)
    }

}