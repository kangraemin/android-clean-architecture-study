package com.example.cleanarchitecture.data.animal.remote

import com.example.cleanarchitecture.data.animal.CatImageItem
import io.reactivex.Single

interface RemoteCatImageDataSource {
    fun getRandomCatImage(): Single<CatImageItem>
}