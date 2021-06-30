package com.example.cleanarchitecture.datalayer.remote.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import com.example.cleanarchitecture.datalayer.remote.quote.RemoteQuoteMapper.remoteQuoteItemToQuoteItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteQuoteDataSourceImpl(
    private val quoteApi: QuoteApi
) : RemoteQuoteDataSource {
    override fun getRandomQuote(): Single<QuoteItem> {
        return quoteApi
            .getQuoteItem()
            .subscribeOn(Schedulers.io())
            .map { remoteQuoteItemToQuoteItem(it.first()) }
    }
}