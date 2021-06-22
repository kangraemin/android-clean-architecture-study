package com.example.cleanarchitecture.data.quote.local

import com.example.cleanarchitecture.data.quote.QuoteItem
import com.example.cleanarchitecture.data.quote.local.LocalQuoteMapper.localQuoteItemToQuoteItem
import com.example.cleanarchitecture.data.quote.local.LocalQuoteMapper.quoteItemToLocalQuoteItem
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocalQuoteDataSourceImpl(
    private val localQuoteItemDao: LocalQuoteItemDao
) : LocalQuoteDataSource {
    override fun getQuote(): Single<QuoteItem> {
        return localQuoteItemDao
            .getQuote()
            .subscribeOn(Schedulers.io())
            .map { localQuoteItemToQuoteItem(it) }
    }

    override fun insertQuote(quoteItem: QuoteItem): Completable {
        return localQuoteItemDao
            .insertQuote( quoteItemToLocalQuoteItem(quoteItem) )
            .subscribeOn(Schedulers.io())
    }

    override fun deleteAllQuotes(): Completable {
        return localQuoteItemDao
            .deleteAllQuotes()
            .subscribeOn(Schedulers.io())
    }
}