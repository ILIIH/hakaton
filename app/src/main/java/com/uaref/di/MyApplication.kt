package com.uaref.di

import android.app.Application
import com.example.auth_data.di.authDataModule
import com.example.auth_ui.di.authModule
import com.example.servise_review_ui.di.serviseReviewModule
import com.example.servise_reviw_data.di.serviseReviewDataModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import com.uaref.di.homeModule


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)

            modules(
                appModule,
                authModule,
                authDataModule,
                serviseReviewDataModel,
                serviseReviewModule,
                homeDomainModule,
                homeDataModule,
                serviceModule
                homeModule
            )
        }
    }
}
