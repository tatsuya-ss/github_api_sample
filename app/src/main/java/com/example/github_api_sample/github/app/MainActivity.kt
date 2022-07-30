package com.example.github_api_sample.github.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.github_api_sample.R
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
    private val fetchUserUseCase = FetchUserUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutineScope.launch {
            val result = fetchUserUseCase.invoke("tatsuya-ss")
            when (result) {
                is Result.Success -> {
                    Log.d("Tatsuyað", "onCreate: ${result.result.name}")
                }
                is Result.Failure -> {
                    Log.d("Tatsuyað", "onCreate: ${result.exception.message}")
                }
            }
        }
    }
}
