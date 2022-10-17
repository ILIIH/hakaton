package com.example.auth_domain.models.usecases

import com.example.auth_domain.models.models.userDomain
import com.example.auth_domain.models.repository.authRepository

class registrate(private val repository: authRepository) {
    suspend fun execute(user: userDomain) = repository.registrate(user)
}
