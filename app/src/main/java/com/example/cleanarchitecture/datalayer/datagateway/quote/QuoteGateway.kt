package com.example.cleanarchitecture.datalayer.datagateway.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import io.reactivex.Single

interface QuoteGateway {
    fun getRandomQuote(): Single<QuoteItem>
}