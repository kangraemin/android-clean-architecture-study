package com.example.cleanarchitecture.data.animal.remote

import com.example.cleanarchitecture.data.animal.CatImageItem
import com.example.cleanarchitecture.data.animal.remote.RemoteCatImageMapper.remoteCatImageItemToCatImageItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteCatImageDataSourceImpl(
    private val catImageApi: CatImageApi
) : RemoteCatImageDataSource {
    override fun getRandomCatImage(): Single<CatImageItem> {
        return catImageApi
            .getRandomCatImage()
            .subscribeOn(Schedulers.io())
            .map { remoteCatImageItemToCatImageItem(it.first()) }
    }
}