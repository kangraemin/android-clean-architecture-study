package com.example.cleanarchitecture.ui

import android.app.Application
import com.example.cleanarchitecture.module.remoteModule
import com.example.cleanarchitecture.module.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                remoteModule, viewModule
            )
        }
    }
}