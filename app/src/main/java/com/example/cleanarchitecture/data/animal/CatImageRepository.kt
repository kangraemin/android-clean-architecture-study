package com.example.cleanarchitecture.data.animal

import io.reactivex.Single

interface CatImageRepository {
    fun getRandomCatImage(): Single<CatImageItem>
}