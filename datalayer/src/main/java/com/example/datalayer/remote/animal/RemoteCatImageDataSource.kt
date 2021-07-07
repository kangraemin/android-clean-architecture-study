package com.example.datalayer.remote.animal

import com.example.datalayer.entity.CatImageEntity
import io.reactivex.Single

interface RemoteCatImageDataSource {
    fun getRandomCatImage(): Single<CatImageEntity>
}