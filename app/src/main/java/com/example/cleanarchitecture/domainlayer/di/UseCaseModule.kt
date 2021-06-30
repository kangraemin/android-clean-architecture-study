package com.example.cleanarchitecture.domainlayer.di

import com.example.cleanarchitecture.domainlayer.usecase.animal.CatImageUseCaseInteractor
import org.koin.dsl.module

val useCaseModule = module {
    single { CatImageUseCaseInteractor(get(), get()) }
}