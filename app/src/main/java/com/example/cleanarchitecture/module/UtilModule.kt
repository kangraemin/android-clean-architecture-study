package com.example.cleanarchitecture.module

import com.example.cleanarchitecture.util.NetworkUtil
import org.koin.dsl.module

val utilModule = module {
    // For NetworkUtil instance
    single { NetworkUtil(get()) }
}