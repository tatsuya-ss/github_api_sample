package com.example.github_api_sample.github.data.mapper

import com.example.github_api_sample.github.domain.model.Repository as RepositoryModel
import com.example.github_api_sample.github.data.entity.Repository as RepositoryEntity

fun List<RepositoryEntity>.convertToModel(): List<RepositoryModel> {
    return map { it.convertToModel() }
}

fun RepositoryEntity.convertToModel(): RepositoryModel {
    return RepositoryModel(
        name,
        createdAt,
        htmlUrl,
    )
}