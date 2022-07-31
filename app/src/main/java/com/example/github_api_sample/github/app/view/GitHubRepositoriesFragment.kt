package com.example.github_api_sample.github.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_api_sample.R
import com.example.github_api_sample.databinding.FragmentGitHubBinding
import com.example.github_api_sample.github.app.viewmodel.GitHubViewModel

class GitHubRepositoriesFragment : Fragment() {

    private lateinit var binding: FragmentGitHubBinding
    private val viewModel = GitHubViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_git_hub, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.onFetchRepositories()
    }

    private fun observeLiveData() {
        viewModel.repositories.observe(this) {
            binding.rvRepositories.adapter = GitHubRepositoriesAdapter(it)
            binding.rvRepositories.layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return GitHubRepositoriesFragment()
        }
    }
}