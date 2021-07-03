package com.example.datalayer.datagateway.quote

import com.example.datalayer.entity.QuoteItem
import io.reactivex.Single

interface QuoteGateway {
    fun getRandomQuote(): Single<QuoteItem>
}