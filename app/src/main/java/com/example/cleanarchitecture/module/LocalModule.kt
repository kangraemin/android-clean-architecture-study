package com.example.cleanarchitecture.module

import androidx.room.Room
import com.example.cleanarchitecture.data.AppDatabase
import com.example.cleanarchitecture.data.quote.local.LocalQuoteDataSource
import com.example.cleanarchitecture.data.quote.local.LocalQuoteDataSourceImpl
import com.example.cleanarchitecture.data.quote.local.LocalQuoteItem
import com.example.cleanarchitecture.data.quote.local.LocalQuoteItemDao
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
    single<LocalQuoteDataSource> { LocalQuoteDataSourceImpl(get()) }
}