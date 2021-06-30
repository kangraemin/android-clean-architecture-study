package com.example.cleanarchitecture.datalayer.local.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import io.reactivex.Completable
import io.reactivex.Single

interface LocalQuoteDataSource {
    fun getQuote(): Single<QuoteItem>
    fun insertQuote(quoteItem: QuoteItem): Completable
    fun deleteAllQuotes(): Completable
}