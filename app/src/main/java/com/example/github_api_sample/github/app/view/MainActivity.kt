package com.example.github_api_sample.github.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_api_sample.R
import com.example.github_api_sample.databinding.ActivityMainBinding
import com.example.github_api_sample.github.app.viewmodel.GitHubViewModel
import com.example.github_api_sample.github.domain.model.Result
import com.example.github_api_sample.github.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupButton()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setupButton() {
        binding.btnRepositories.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .addToBackStack(BACK_STACK_TAG)
                .add(R.id.fragmentContainerView, GitHubRepositoriesFragment.newInstance())
                .commit()
        }
    }

    companion object {
        private const val BACK_STACK_TAG = "back_stack_tag"
    }
}
