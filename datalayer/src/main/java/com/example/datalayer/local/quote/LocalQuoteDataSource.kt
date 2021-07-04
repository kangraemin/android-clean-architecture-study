package com.example.datalayer.local.quote

import com.example.datalayer.entity.QuoteEntity
import io.reactivex.Completable
import io.reactivex.Single

interface LocalQuoteDataSource {
    fun getQuote(): Single<QuoteEntity>
    fun insertQuote(quoteEntity: QuoteEntity): Completable
    fun deleteAllQuotes(): Completable
}