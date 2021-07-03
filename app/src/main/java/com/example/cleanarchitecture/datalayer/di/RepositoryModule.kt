package com.example.cleanarchitecture.datalayer.di

import com.example.cleanarchitecture.datalayer.datagateway.animal.CatImageGateway
import com.example.cleanarchitecture.datalayer.datagateway.animal.CatImageGatewayImpl
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

    // For CatImageRepository instance
    single<CatImageGateway> {
        CatImageGatewayImpl(
            get(),
            get(),
            get()
        )
    }
}