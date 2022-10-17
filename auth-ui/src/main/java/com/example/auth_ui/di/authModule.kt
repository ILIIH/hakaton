package com.example.auth_ui.di

import com.example.auth_ui.viewModel.authViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel {
        authViewModel(get(), get(), get())
    }
}
