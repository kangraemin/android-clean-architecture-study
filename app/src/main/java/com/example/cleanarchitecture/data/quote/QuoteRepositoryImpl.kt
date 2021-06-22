package com.example.cleanarchitecture.data.quote

import com.example.cleanarchitecture.data.quote.local.LocalQuoteDataSource
import com.example.cleanarchitecture.data.quote.remote.RemoteQuoteDataSource
import com.example.cleanarchitecture.exception.TooManyRequest
import com.example.cleanarchitecture.util.NetworkUtil
import io.reactivex.Single

class QuoteRepositoryImpl(
    private val localQuoteDataSource: LocalQuoteDataSource,
    private val remoteQuoteDataSource: RemoteQuoteDataSource,
    private val networkUtil: NetworkUtil
) : QuoteRepository {
    override fun getRandomQuote(): Single<QuoteItem> {
        return Single
            .defer {
                if (!networkUtil.isNetworkConnected()) {
                    return@defer localQuoteDataSource
                        .getQuote()
                } else {
                    return@defer remoteQuoteDataSource
                        .getRandomQuote()
                        .flatMap { quoteItem ->
                            localQuoteDataSource
                                .deleteAllQuotes()
                                .andThen(localQuoteDataSource.insertQuote(quoteItem))
                                .toSingleDefault(quoteItem)
                        }
                        .onErrorResumeNext {
                            if (it is TooManyRequest) {
                                return@onErrorResumeNext localQuoteDataSource
                                    .getQuote()
                            }
                            throw it
                        }
                }
            }
    }
}