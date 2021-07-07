package com.example.datalayer.datagateway.quote

import com.example.datalayer.entity.QuoteEntity
import io.reactivex.Single

interface QuoteGateway {
    fun getRandomQuote(): Single<QuoteEntity>
}