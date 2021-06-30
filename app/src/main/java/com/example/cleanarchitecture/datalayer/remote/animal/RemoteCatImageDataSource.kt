package com.example.cleanarchitecture.datalayer.remote.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import io.reactivex.Single

interface RemoteCatImageDataSource {
    fun getRandomCatImage(): Single<CatImageItem>
}