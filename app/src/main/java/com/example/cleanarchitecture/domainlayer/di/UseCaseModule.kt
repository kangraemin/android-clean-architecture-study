package com.example.cleanarchitecture.domainlayer.di

import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractor
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractor
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractorImpl
import com.example.cleanarchitecture.domainlayer.usecase.user.UserUseCaseInteractor
import com.example.cleanarchitecture.domainlayer.usecase.user.UserUseCaseInteractorImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<CatImageUseCaseInteractor> { CatImageUseCaseInteractorImpl(get()) }

    single<QuoteUseCaseInteractor> { QuoteUseCaseInteractorImpl(get()) }

    single<UserUseCaseInteractor> { UserUseCaseInteractorImpl(get(), get()) }
}