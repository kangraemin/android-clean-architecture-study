package com.example.datalayer.remote.animal

import com.example.datalayer.entity.CatImageItem
import io.reactivex.Single

interface RemoteCatImageDataSource {
    fun getRandomCatImage(): Single<CatImageItem>
}