package com.example.datalayer.local.quote

import com.example.datalayer.entity.QuoteEntity
import com.example.datalayer.local.quote.LocalQuoteMapper.localQuoteItemToQuoteItem
import com.example.datalayer.local.quote.LocalQuoteMapper.quoteItemToLocalQuoteItem
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocalQuoteDataSourceImpl(
    private val localQuoteItemDao: LocalQuoteItemDao
) : LocalQuoteDataSource {
    override fun getQuote(): Single<QuoteEntity> {
        return localQuoteItemDao
            .getQuote()
            .subscribeOn(Schedulers.io())
            .map { localQuoteItemToQuoteItem(it) }
    }

    override fun insertQuote(quoteEntity: QuoteEntity): Completable {
        return localQuoteItemDao
            .insertQuote( quoteItemToLocalQuoteItem(quoteEntity) )
            .subscribeOn(Schedulers.io())
    }

    override fun deleteAllQuotes(): Completable {
        return localQuoteItemDao
            .deleteAllQuotes()
            .subscribeOn(Schedulers.io())
    }
}