package com.example.servise_reviw_data.repository

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.servise
import com.example.servise_review_domain.repository.seviseReviewRepository
import com.example.servise_reviw_data.factory.serviseFactory

class serviseRegistrateRepositoryImp : seviseReviewRepository {
    override suspend fun getServise(uname: String): servise {
        return serviseFactory().get().filter { it.username == uname }.first()
    }

    override suspend fun getCommentsByUsername(uname: String): List<comment> {
        val usersServise = serviseFactory().get().filter { it.username == uname }
        return usersServise.first().comments
    }
}
