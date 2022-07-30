package com.example.github_api_sample.github.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_api_sample.github.domain.model.Failure
import com.example.github_api_sample.github.domain.model.Success
import com.example.github_api_sample.github.domain.model.User
import com.example.github_api_sample.github.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.launch

class GitHubViewModel() : ViewModel() {

    private val fetchUserUseCase = FetchUserUseCase()

    private val _userData: MutableLiveData<User> = MutableLiveData()
    val userData: LiveData<User> = _userData

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
}