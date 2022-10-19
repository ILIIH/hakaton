package com.example.servise_review_domain.repository

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.servise

interface seviseReviewRepository {
    suspend fun getServise(uname: String): servise
    suspend fun getCommentsByUsername(username: String): List<comment>
}
