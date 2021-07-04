package com.example.datalayer.remote.animal

import com.example.datalayer.entity.CatImageEntity
import com.example.datalayer.remote.animal.RemoteCatImageMapper.remoteCatImageItemToCatImageItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteCatImageDataSourceImpl(
    private val catImageApi: CatImageApi
) : RemoteCatImageDataSource {
    override fun getRandomCatImage(): Single<CatImageEntity> {
        return catImageApi
            .getRandomCatImage()
            .subscribeOn(Schedulers.io())
            .map { remoteCatImageItemToCatImageItem(it.first()) }
    }
}