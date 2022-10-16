package com.example.auth_data.repository

import com.example.auth_domain.models.models.userDomain
import com.example.auth_domain.models.repository.authRepository

class authRepositoryImpl : authRepository {
    override suspend fun getUserByLogin(login: String): userDomain? {
        TODO("Not yet implemented")
    }

    override suspend fun registrate(user: userDomain):Boolean {
        TODO("Not yet implemented")
    }
}