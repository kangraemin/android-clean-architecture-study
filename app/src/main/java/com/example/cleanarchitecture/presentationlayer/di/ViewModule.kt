package com.example.cleanarchitecture.presentationlayer.di

import com.example.cleanarchitecture.presentationlayer.ui.main.MainViewModel
import org.koin.dsl.module

val viewModule = module {
    single { MainViewModel(get(), get()) }
}