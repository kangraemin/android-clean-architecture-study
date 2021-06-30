package com.example.cleanarchitecture.datalayer.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.datalayer.local.animal.LocalCatImageDao
import com.example.cleanarchitecture.datalayer.local.animal.LocalCatImageItem
import com.example.cleanarchitecture.datalayer.local.quote.LocalQuoteItem
import com.example.cleanarchitecture.datalayer.local.quote.LocalQuoteItemDao

@Database(entities = [LocalQuoteItem::class, LocalCatImageItem::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): LocalQuoteItemDao
    abstract fun catImageDao(): LocalCatImageDao
}