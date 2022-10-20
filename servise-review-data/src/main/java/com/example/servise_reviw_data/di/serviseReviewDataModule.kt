package com.example.servise_reviw_data.di
import com.example.servise_review_domain.repository.seviseReviewRepository
import com.example.servise_review_domain.usecase.getComments
import com.example.servise_review_domain.usecase.getServiseEuropean
import com.example.servise_review_domain.usecase.getServiseUkrainian
import com.example.servise_review_domain.usecase.getUserInfo
import com.example.servise_reviw_data.repository.serviseRegistrateRepositoryImp
import org.koin.dsl.module

val serviseReviewDataModel = module {
    single<seviseReviewRepository> { serviseRegistrateRepositoryImp() }
    single {
        getComments(get())
    }
    single {
        getServiseUkrainian(get())
    }
    single {
        getServiseEuropean(get())
    }
    single{
        getUserInfo(get())
    }
}
