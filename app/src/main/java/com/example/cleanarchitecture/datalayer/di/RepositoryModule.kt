package com.example.cleanarchitecture.datalayer.di

import com.example.cleanarchitecture.datalayer.datagateway.quote.QuoteGateway
import com.example.cleanarchitecture.datalayer.datagateway.quote.QuoteGatewayImpl
import org.koin.dsl.module

val repositoryModule = module {
    // For QuoteRepository instance
    single<QuoteGateway> {
        QuoteGatewayImpl(
            get(),
            get(),
            get()
        )
    }
}