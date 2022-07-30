package com.example.github_api_sample.github.data.service

import com.example.github_api_sample.github.data.entity.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}")
    suspend fun fetchUser(
        @Path("user") user: String
    ): User
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

