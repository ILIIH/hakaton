package com.example.servise_review_ui.di

import com.example.servise_review_ui.mapping.commentsMapper
import com.example.servise_review_ui.viewModel.ServiseReviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviseReviewModule = module {
    viewModel {
        ServiseReviewViewModel(get(), get(), get(), get(), get())
    }
    single {
        commentsMapper()
    }
}
