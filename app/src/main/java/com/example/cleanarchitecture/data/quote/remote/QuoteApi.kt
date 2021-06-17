package com.example.cleanarchitecture.data.quote.remote

import io.reactivex.Single
import retrofit2.http.GET

interface QuoteApi {
    @GET("https://zenquotes.io/api/random")
    fun getQuoteItem() : Single<RemoteQuoteItem>
}