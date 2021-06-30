package com.example.cleanarchitecture.datalayer.datagateway.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import com.example.cleanarchitecture.datalayer.local.quote.LocalQuoteDataSource
import com.example.cleanarchitecture.datalayer.remote.quote.RemoteQuoteDataSource
import com.example.cleanarchitecture.datalayer.exception.TooManyRequest
import com.example.cleanarchitecture.util.NetworkUtil
import io.reactivex.Single

class QuoteGatewayImpl(
    private val localQuoteDataSource: LocalQuoteDataSource,
    private val remoteQuoteDataSource: RemoteQuoteDataSource,
    private val networkUtil: NetworkUtil
) : QuoteGateway {
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