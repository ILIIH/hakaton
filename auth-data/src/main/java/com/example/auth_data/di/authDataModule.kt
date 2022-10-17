package com.example.auth_data.di

import com.example.auth_data.repository.authApi
import com.example.auth_domain.models.repository.authRepository
import com.example.auth_domain.models.usecases.getUser
import com.example.auth_domain.models.usecases.login
import com.example.auth_domain.models.usecases.registrate
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val authDataModule = module {
    single<authRepository> { authApi(androidContext()) }
    single {
        login(get())
    }
    single {
        registrate(get())
    }
    single {
        getUser(get())
    }
}
