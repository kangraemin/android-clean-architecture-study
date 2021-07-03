package com.example.datalayer.datagateway.quote

import com.example.datalayer.entity.QuoteItem
import com.example.datalayer.exception.TooManyRequest
import com.example.datalayer.local.quote.LocalQuoteDataSource
import com.example.datalayer.remote.quote.RemoteQuoteDataSource
import com.example.datalayer.util.NetworkUtil
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