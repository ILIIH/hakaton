package com.example.uaref.di

import android.app.Application
import com.example.auth_data.di.authDataModule
import com.example.auth_ui.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)

            modules(
                appModule,
                authModule,
                authDataModule
            )
        }
    }
}
