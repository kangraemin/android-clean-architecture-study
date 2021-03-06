package com.example.datalayer.di

import androidx.room.Room
import com.example.datalayer.local.AppDatabase
import com.example.datalayer.local.animal.LocalCatImageDataSource
import com.example.datalayer.local.animal.LocalCatImageDataSourceImpl
import com.example.datalayer.local.quote.LocalQuoteDataSource
import com.example.datalayer.local.quote.LocalQuoteDataSourceImpl
import org.koin.dsl.module

val localModule = module {
    // For AppDatabase instance
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "local"
        ).build()
    }

    // For LocalQuoteItemDao instance
    single { get<AppDatabase>().quoteDao() }

    // For LocalQuoteDataSource instance
    single<LocalQuoteDataSource> {
        LocalQuoteDataSourceImpl(
            get()
        )
    }

    // For LocalCatImageDao instance
    single { get<AppDatabase>().catImageDao() }

    // For LocalCatImageDataSource instance
    single<LocalCatImageDataSource> {
        LocalCatImageDataSourceImpl(
            get()
        )
    }
}