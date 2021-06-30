package com.example.cleanarchitecture.datalayer.local.quote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanarchitecture.datalayer.local.quote.LocalQuoteItem
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface LocalQuoteItemDao {
    @Query("SELECT * FROM quotes LIMIT 1")
    fun getQuote(): Single<LocalQuoteItem>

    @Insert
    fun insertQuote(localQuoteItem: LocalQuoteItem): Completable

    @Query("DELETE FROM quotes")
    fun deleteAllQuotes(): Completable
}