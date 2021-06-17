package com.example.cleanarchitecture.module

import com.example.cleanarchitecture.data.quote.QuoteRepository
import com.example.cleanarchitecture.data.quote.QuoteRepositoryImpl
import com.example.cleanarchitecture.data.quote.remote.QuoteApi
import com.example.cleanarchitecture.data.quote.remote.RemoteQuoteDataSource
import com.example.cleanarchitecture.data.quote.remote.RemoteQuoteDataSourceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {

    // For HttpLoggingInterceptor instance
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    // For OkHttpClient instance
    single {
        OkHttpClient
            .Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    // For GsonConverterFactory instance
    single {
        GsonConverterFactory.create()
    }

    // For RxJava2CallAdapterFactory instance
    single { RxJava2CallAdapterFactory.create() }

    // For Retrofit instance
    single {
        Retrofit
            .Builder()
            .baseUrl("https://zenquotes.io")
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    // For QuoteApi instance
    single { get<Retrofit>().create(QuoteApi::class.java) }

    // For RemoteQuoteDataSource instance
    single<RemoteQuoteDataSource> { RemoteQuoteDataSourceImpl(get()) }

    // For QuoteRepository instance
    single<QuoteRepository> { QuoteRepositoryImpl(get()) }
}