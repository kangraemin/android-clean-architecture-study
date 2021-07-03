package com.example.datalayer.local.quote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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