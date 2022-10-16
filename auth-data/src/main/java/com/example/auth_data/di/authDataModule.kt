package com.example.auth_data.di

import com.example.auth_data.sourses.authApi
import com.example.auth_domain.models.usecases.login
import com.example.auth_domain.models.usecases.registrate
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val authDataModule = module {
    single {
        authApi(androidContext())
        login(get())
        registrate(get())
    }
}
