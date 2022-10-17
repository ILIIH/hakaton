package com.example.auth_domain.models.usecases

import com.example.auth_domain.models.repository.authRepository

class getUser(private val repository: authRepository) {
    suspend fun execute(username: String) = repository.getUserByLogin(username)
}
