package com.example.cleanarchitecture.module

import com.example.cleanarchitecture.ui.main.MainViewModel
import org.koin.dsl.module

val viewModule = module {
    single { MainViewModel(get(), get()) }
}