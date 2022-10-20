package com.uaref.di

import com.uaref.mapper.ServiceTimeMapper
import com.uaref.viewModel.NewServiceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {
    viewModel {
        NewServiceViewModel(get())
    }
    single {
        ServiceTimeMapper()
    }
}
