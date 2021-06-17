package com.example.cleanarchitecture.data.quote.remote

import com.example.cleanarchitecture.data.quote.QuoteItem
import com.example.cleanarchitecture.data.quote.remote.RemoteQuoteMapper.remoteQuoteItemToQuoteItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteQuoteDataSourceImpl(
    private val quoteApi: QuoteApi
) : RemoteQuoteDataSource {
    override fun getRandomQuote(): Single<QuoteItem> {
        return quoteApi
            .getQuoteItem()
            .subscribeOn(Schedulers.io())
            .map { remoteQuoteItemToQuoteItem(it) }
    }
}