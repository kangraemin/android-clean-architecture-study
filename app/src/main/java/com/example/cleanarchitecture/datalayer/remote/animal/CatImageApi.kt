package com.example.cleanarchitecture.datalayer.remote.animal

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface CatImageApi {
    @GET
    fun getRandomCatImage(@Url url: String = "https://api.thecatapi.com/v1/images/search"): Single<List<RemoteCatImageItem>>
}