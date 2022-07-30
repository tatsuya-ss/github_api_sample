package com.example.github_api_sample.github.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.github_api_sample.R
import com.example.github_api_sample.databinding.ActivityMainBinding
import com.example.github_api_sample.github.app.viewmodel.GitHubViewModel
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = GitHubViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        observeLiveData()
        viewModel.onCreate()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun observeLiveData() {
        viewModel.userData.observe(this) {
            binding.tvName.text = it.name
        }
    }
}
