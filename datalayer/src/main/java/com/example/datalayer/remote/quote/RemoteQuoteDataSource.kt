package com.example.datalayer.remote.quote

import com.example.datalayer.entity.QuoteItem
import io.reactivex.Single

interface RemoteQuoteDataSource {
    fun getRandomQuote(): Single<QuoteItem>
}