package com.example.cleanarchitecture.presentationlayer.di

import com.example.cleanarchitecture.presentationlayer.util.NetworkUtil
import org.koin.dsl.module

val utilModule = module {
    // For NetworkUtil instance
    single { NetworkUtil(get()) }
}