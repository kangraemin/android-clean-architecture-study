package com.example.datalayer.di

import com.example.datalayer.datagateway.animal.CatImageGateway
import com.example.datalayer.datagateway.animal.CatImageGatewayImpl
import com.example.datalayer.datagateway.quote.QuoteGateway
import com.example.datalayer.datagateway.quote.QuoteGatewayImpl
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