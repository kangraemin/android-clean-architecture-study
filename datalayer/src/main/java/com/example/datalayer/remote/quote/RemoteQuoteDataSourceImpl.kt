package com.example.datalayer.remote.quote

import com.example.datalayer.entity.QuoteEntity
import com.example.datalayer.remote.quote.RemoteQuoteMapper.remoteQuoteItemToQuoteItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteQuoteDataSourceImpl(
    private val quoteApi: QuoteApi
) : RemoteQuoteDataSource {
    override fun getRandomQuote(): Single<QuoteEntity> {
        return quoteApi
            .getQuoteItem()
            .subscribeOn(Schedulers.io())
            .map { remoteQuoteItemToQuoteItem(it.first()) }
    }
}