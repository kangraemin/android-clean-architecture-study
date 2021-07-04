package com.example.datalayer.remote.quote

import com.example.datalayer.entity.QuoteEntity
import io.reactivex.Single

interface RemoteQuoteDataSource {
    fun getRandomQuote(): Single<QuoteEntity>
}