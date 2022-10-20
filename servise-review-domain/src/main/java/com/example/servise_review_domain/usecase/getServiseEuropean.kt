package com.example.servise_review_domain.usecase

import com.example.servise_review_domain.models.mapper.asServise
import com.example.servise_review_domain.repository.seviseReviewRepository

class getServiseEuropean constructor(private val repository: seviseReviewRepository) {
    suspend fun execute(id: Int) = repository.getServiseEuropean(id).asServise()
}