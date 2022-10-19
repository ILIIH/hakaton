package com.uaref.di

import com.uaref.usecase.GetListEuropeansUseCase
import com.uaref.usecase.GetListUkrainiansUseCase
import com.uaref.usecase.impl.GetListEuropeansUseCaseImpl
import com.uaref.usecase.impl.GetListUkrainiansUseCaseImpl
import org.koin.dsl.module

val homeDomainModule = module {
    single<GetListUkrainiansUseCase> {
        GetListUkrainiansUseCaseImpl(get())
    }
    single<GetListEuropeansUseCase> {
        GetListEuropeansUseCaseImpl(get())
    }
}
