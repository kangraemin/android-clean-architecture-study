package com.example.cleanarchitecture.datalayer.remote.quote

import io.reactivex.Single
import retrofit2.http.GET

interface QuoteApi {
    @GET("/api/random")
    fun getQuoteItem() : Single<List<RemoteQuoteItem>>
}