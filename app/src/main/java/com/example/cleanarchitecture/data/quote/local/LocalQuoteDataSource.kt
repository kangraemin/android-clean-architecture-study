package com.example.cleanarchitecture.data.quote.local

import com.example.cleanarchitecture.data.quote.QuoteItem
import io.reactivex.Completable
import io.reactivex.Single

interface LocalQuoteDataSource {
    fun getQuote(): Single<QuoteItem>
    fun insertQuote(quoteItem: QuoteItem): Completable
    fun deleteAllQuotes(): Completable
}