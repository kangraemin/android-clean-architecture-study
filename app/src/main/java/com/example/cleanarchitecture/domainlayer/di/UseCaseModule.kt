package com.example.cleanarchitecture.domainlayer.di

import com.example.cleanarchitecture.domainlayer.usecase.animal.CatImageUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.quote.QuoteUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.user.EntireDataUseCaseInteractorImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { CatImageUseCaseInteractorImpl(get()) }

    single { QuoteUseCaseInteractorImpl(get()) }

    single { EntireDataUseCaseInteractorImpl(get(), get()) }
}