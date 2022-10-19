package com.example.servise_reviw_data.di
import com.example.servise_review_domain.repository.seviseReviewRepository
import com.example.servise_review_domain.usecase.getComments
import com.example.servise_review_domain.usecase.getServise
import com.example.servise_reviw_data.repository.serviseRegistrateRepositoryImp
import org.koin.dsl.module

val serviseReviewDataModel = module {
    single<seviseReviewRepository> { serviseRegistrateRepositoryImp() }
    single {
        getComments(get())
    }
    single {
        getServise(get())
    }
}
