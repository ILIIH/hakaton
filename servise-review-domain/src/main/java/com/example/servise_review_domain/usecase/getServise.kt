package com.example.servise_review_domain.usecase

import com.example.servise_review_domain.repository.seviseReviewRepository

class getServise constructor(private val repository: seviseReviewRepository) {
    suspend fun execute(username: String) = repository.getServise(username)
}
