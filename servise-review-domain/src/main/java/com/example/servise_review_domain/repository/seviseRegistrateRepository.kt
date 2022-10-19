package com.example.servise_review_domain.repository

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.servise

interface seviseRegistrateRepository {
    suspend fun getServise(username: String): servise
    suspend fun getComments(username: String): List<comment>
}
