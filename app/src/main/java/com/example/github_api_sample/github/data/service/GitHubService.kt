package com.example.github_api_sample.github.data.service

import com.example.github_api_sample.github.data.entity.Repository
import com.example.github_api_sample.github.data.entity.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("users/{USERNAME}")
    suspend fun fetchUser(
        @Path("USERNAME") userName: String
    ): User

    @GET("users/{USERNAME}/repos")
    suspend fun fetchRepositories(
        @Path("USERNAME") userName: String,
        @Query("sort") sort: String,
    ): List<Repository>
}

class CreateService {
    fun createService(): GitHubService {
        val retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GitHubService::class.java)
    }

    companion object {
        private const val GITHUB_URL = "https://api.github.com/"
    }
}

