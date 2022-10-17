package com.example.auth_domain.models.usecases

import com.example.auth_domain.models.models.userDomain
import com.example.auth_domain.models.repository.authRepository

class login(private val repository: authRepository) {
    suspend fun execute(user: userDomain): Boolean {
        val user2 = repository.getUserByLogin(user.username)
        return user.passwors == (user2?.passwors ?: false)
    }
}
