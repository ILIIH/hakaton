package com.uaref.di

import com.uaref.mapper.EuropeanMapper
import com.uaref.mapper.UkrainianMapper
import com.uaref.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(get(), get(), get(), get())
    }

    single {
        EuropeanMapper()
    }

    single {
        UkrainianMapper()
    }
}
