package com.example.github_api_sample.github.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_api_sample.github.domain.model.Failure
import com.example.github_api_sample.github.domain.model.Repository
import com.example.github_api_sample.github.domain.model.Success
import com.example.github_api_sample.github.domain.model.User
import com.example.github_api_sample.github.domain.usecase.FetchRepositoriesUseCase
import com.example.github_api_sample.github.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.launch

class GitHubViewModel() : ViewModel() {

    private val fetchUserUseCase = FetchUserUseCase()
    private val fetchRepositoriesUseCase = FetchRepositoriesUseCase()

    private val _userData: MutableLiveData<User> = MutableLiveData()
    val userData: LiveData<User> = _userData

    private val _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>> = _repositories

    fun onCreate() {
        viewModelScope.launch {
            val result = fetchUserUseCase.invoke("tatsuya-ss")
            when (result) {
                is Success -> {
                    _userData.value = result.value ?: User("")
                }
                is Failure -> {
                    Log.d("Tatsuyað", "onCreate: ${result.reason.message}")
                }
            }
        }
    }

    fun onFetchRepositories() {
        viewModelScope.launch {
            val result = fetchRepositoriesUseCase.invoke("tatsuya-ss", "created")
            when (result) {
                is Success -> {
                    _repositories.value = result.value ?: listOf()
                }
                is Failure -> {
                    Log.d("Tatsuyað", "onCreate: ${result.reason.message}")
                }
            }
        }
    }
}