package com.example.domainlayer.di

import com.example.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractor
import com.example.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractorImpl
import com.example.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractor
import com.example.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractorImpl
import com.example.domainlayer.usecase.user.UserUseCaseInteractor
import com.example.domainlayer.usecase.user.UserUseCaseInteractorImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<CatImageUseCaseInteractor> { CatImageUseCaseInteractorImpl(get()) }

    single<QuoteUseCaseInteractor> { QuoteUseCaseInteractorImpl(get()) }

    single<UserUseCaseInteractor> { UserUseCaseInteractorImpl(get(), get()) }
}