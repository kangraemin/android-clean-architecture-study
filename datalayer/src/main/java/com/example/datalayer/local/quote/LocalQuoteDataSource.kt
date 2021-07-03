package com.example.datalayer.local.quote

import com.example.datalayer.entity.QuoteItem
import io.reactivex.Completable
import io.reactivex.Single

interface LocalQuoteDataSource {
    fun getQuote(): Single<QuoteItem>
    fun insertQuote(quoteItem: QuoteItem): Completable
    fun deleteAllQuotes(): Completable
}