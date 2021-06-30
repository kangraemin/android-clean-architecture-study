package com.example.cleanarchitecture.datalayer.remote.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import io.reactivex.Single

interface RemoteQuoteDataSource {
    fun getRandomQuote(): Single<QuoteItem>
}