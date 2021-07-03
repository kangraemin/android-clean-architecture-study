package com.example.cleanarchitecture.presentationlayer.ui

import android.app.Application
import com.example.cleanarchitecture.datalayer.di.localModule
import com.example.cleanarchitecture.datalayer.di.remoteModule
import com.example.cleanarchitecture.datalayer.di.repositoryModule
import com.example.cleanarchitecture.domainlayer.di.useCaseModule
import com.example.cleanarchitecture.presentationlayer.di.utilModule
import com.example.cleanarchitecture.presentationlayer.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                remoteModule, localModule, repositoryModule,
                useCaseModule,
                utilModule, viewModule
            )
        }
    }
}