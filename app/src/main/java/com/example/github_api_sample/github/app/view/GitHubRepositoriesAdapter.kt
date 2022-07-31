package com.example.github_api_sample.github.app.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.github_api_sample.R
import com.example.github_api_sample.databinding.GithubRepositoryAdapterBinding
import com.example.github_api_sample.github.domain.model.Repository

class GitHubRepositoriesAdapter(
    private val repositories: List<Repository>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.github_repository_adapter, parent, false
        )
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RepositoryViewHolder) {
            holder.setData(repositories[position])
        }
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: GithubRepositoryAdapterBinding = DataBindingUtil.bind(view)!!

        fun setData(repository: Repository) {
            binding.tvName.text = repository.name
            binding.tvCreatedAt.text = repository.createdAt
        }
    }
}