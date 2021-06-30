package com.example.cleanarchitecture.ui

import android.app.Application
import com.example.cleanarchitecture.datalayer.di.localModule
import com.example.cleanarchitecture.datalayer.di.remoteModule
import com.example.cleanarchitecture.datalayer.di.repositoryModule
import com.example.cleanarchitecture.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                remoteModule, viewModule,
                localModule,
                repositoryModule, utilModule
            )
        }
    }
}