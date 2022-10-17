package com.example.auth_domain.models.repository

import com.example.auth_domain.models.models.userDomain

interface authRepository {
    suspend fun getUserByLogin(login: String): userDomain?
    suspend fun registrate(user: userDomain): Boolean
}
