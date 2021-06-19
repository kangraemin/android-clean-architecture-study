package com.example.cleanarchitecture.data.animal.local

import com.example.cleanarchitecture.data.animal.CatImageItem
import com.example.cleanarchitecture.data.animal.local.LocalCatImageItemMapper.catImageItemToLocalCatImageItem
import com.example.cleanarchitecture.data.animal.local.LocalCatImageItemMapper.localCatImageItemToCatImageItem
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocalCatImageDataSourceImpl(
    private val localCatImageDao: LocalCatImageDao
) : LocalCatImageDataSource {
    override fun getCatImage(): Single<CatImageItem> {
        return localCatImageDao
            .getCatImage()
            .subscribeOn(Schedulers.io())
            .map { localCatImageItemToCatImageItem(it) }
    }

    override fun insertCatImage(catImageItem: CatImageItem): Completable {
        return localCatImageDao
            .insertCatImage(localCatImageItem = catImageItemToLocalCatImageItem(catImageItem))
            .subscribeOn(Schedulers.io())
    }

    override fun deleteAllCatImage(): Completable {
        return localCatImageDao
            .deleteAllCatImage()
            .subscribeOn(Schedulers.io())
    }
}