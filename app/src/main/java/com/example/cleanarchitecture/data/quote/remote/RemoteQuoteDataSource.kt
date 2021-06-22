package com.example.cleanarchitecture.data.quote.remote

import com.example.cleanarchitecture.data.quote.QuoteItem
import io.reactivex.Single

interface RemoteQuoteDataSource {
    fun getRandomQuote(): Single<QuoteItem>
}