package com.example.servise_review_ui.di

import com.example.servise_review_ui.viewModel.serviseReviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviseReviewModule = module {
    viewModel {
        serviseReviewViewModel(get(), get())
    }
}
