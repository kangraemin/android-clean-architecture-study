package com.example.cleanarchitecture.data.quote

import com.example.cleanarchitecture.data.quote.remote.RemoteQuoteDataSource
import io.reactivex.Single

class QuoteRepositoryImpl(
    private val remoteQuoteDataSource: RemoteQuoteDataSource
) : QuoteRepository {
    override fun getQuote(): Single<QuoteItem> {
        return remoteQuoteDataSource.getRandomQuote()
    }
}