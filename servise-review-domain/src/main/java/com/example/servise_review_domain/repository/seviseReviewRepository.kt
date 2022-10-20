package com.example.servise_review_domain.repository

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.serviceEuropean
import com.example.servise_review_domain.models.serviceUkrainian
import com.example.servise_review_domain.models.userInfo

interface seviseReviewRepository {
    suspend fun getServiseUkrainian(id: Int): serviceUkrainian
    suspend fun getServiseEuropean(id: Int): serviceEuropean
    suspend fun getCommentsByUsername(id: Int, type: String): List<comment>
    suspend fun getuserInfo(id: Int, type: String): userInfo
}
