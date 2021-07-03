package com.example.cleanarchitecture.domainlayer.di

import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.user.UserUseCaseInteractorImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { CatImageUseCaseInteractorImpl(get()) }

    single { QuoteUseCaseInteractorImpl(get()) }

    single { UserUseCaseInteractorImpl(get(), get()) }
}