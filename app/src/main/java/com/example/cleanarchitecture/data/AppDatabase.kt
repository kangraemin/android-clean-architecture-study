package com.example.cleanarchitecture.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.animal.local.LocalCatImageDao
import com.example.cleanarchitecture.data.animal.local.LocalCatImageItem
import com.example.cleanarchitecture.data.quote.local.LocalQuoteItem
import com.example.cleanarchitecture.data.quote.local.LocalQuoteItemDao

@Database(entities = [LocalQuoteItem::class, LocalCatImageItem::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): LocalQuoteItemDao
    abstract fun catImageDao(): LocalCatImageDao
}