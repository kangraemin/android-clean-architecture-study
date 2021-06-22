package com.example.cleanarchitecture.data.quote

import io.reactivex.Single

interface QuoteRepository {
    fun getRandomQuote(): Single<QuoteItem>
}