package com.uaref.di

import com.uaref.factory.EuropeansFactory
import com.uaref.factory.UkrainiansFactory
import com.uaref.repository.EuropeansRepository
import com.uaref.repository.EuropeansRepositoryImpl
import com.uaref.repository.UkrainiansRepository
import com.uaref.repository.UkrainiansRepositoryImpl
import org.koin.dsl.module

val homeDataModule = module {
    single<EuropeansRepository> {
        EuropeansRepositoryImpl(get())
    }

    single<UkrainiansRepository> {
        UkrainiansRepositoryImpl(get())
    }

    single {
        EuropeansFactory()
    }

    single {
        UkrainiansFactory()
    }
}
