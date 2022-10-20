package com.example.servise_review_domain.usecase

import com.example.servise_review_domain.repository.seviseReviewRepository

class getUserInfo(private val repository: seviseReviewRepository) {
    suspend fun execute(id: Int, type: String) = repository.getuserInfo(id, type)
}
