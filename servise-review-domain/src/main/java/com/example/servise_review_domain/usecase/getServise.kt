package com.example.servise_review_domain.usecase

import com.example.servise_review_domain.repository.seviseRegistrateRepository

class getServise constructor(private val repository: seviseRegistrateRepository) {
    suspend fun execute(username: String) = repository.getServise(username)
}
