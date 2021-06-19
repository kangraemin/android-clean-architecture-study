package com.example.cleanarchitecture.module

import com.example.cleanarchitecture.data.quote.QuoteRepository
import com.example.cleanarchitecture.data.quote.QuoteRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    // For QuoteRepository instance
    single<QuoteRepository> { QuoteRepositoryImpl(get(), get(), get()) }
}