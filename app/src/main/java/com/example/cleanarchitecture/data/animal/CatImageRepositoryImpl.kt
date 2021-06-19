package com.example.cleanarchitecture.data.animal

import com.example.cleanarchitecture.data.animal.remote.RemoteCatImageDataSource
import io.reactivex.Single

class CatImageRepositoryImpl (
    private val remoteCatImageDataSource: RemoteCatImageDataSource
) : CatImageRepository {
    override fun getRandomCatImage(): Single<CatImageItem> {
        return remoteCatImageDataSource
            .getRandomCatImage()
    }
}