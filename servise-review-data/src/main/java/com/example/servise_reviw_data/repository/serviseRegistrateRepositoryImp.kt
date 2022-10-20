package com.example.servise_reviw_data.repository

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.serviceEuropean
import com.example.servise_review_domain.models.serviceUkrainian
import com.example.servise_review_domain.models.userInfo
import com.example.servise_review_domain.repository.seviseReviewRepository
import com.example.servise_reviw_data.factory.serviseEuropeanFactory
import com.example.servise_reviw_data.factory.serviseUkrainianFactory
import com.example.servise_reviw_data.factory.userInfoFactory

class serviseRegistrateRepositoryImp : seviseReviewRepository {
    override suspend fun getServiseUkrainian(id: Int): serviceUkrainian {
        return serviseUkrainianFactory().get().first { it.id == id }
    }
    override suspend fun getServiseEuropean(id: Int): serviceEuropean {
        return serviseEuropeanFactory().get().first { it.id == id }
    }
    override suspend fun getCommentsByUsername(id: Int, type: String): List<comment> {
        val usersServiceUk = serviseUkrainianFactory().get().filter { it.id == id }
        val usersServiceEu = serviseEuropeanFactory().get().filter { it.id == id }

        return if (type == "Ukrainian") usersServiceUk.first().comments
        else usersServiceEu.first().comments
    }
    override suspend fun getuserInfo(id: Int, type: String): userInfo {
        return userInfoFactory().get().first { it.id == id && it.type == type }
    }
}
