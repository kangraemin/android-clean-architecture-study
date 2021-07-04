package com.example.datalayer.local.animal

import com.example.datalayer.entity.CatImageEntity
import com.example.datalayer.local.animal.LocalCatImageItemMapper.catImageItemToLocalCatImageItem
import com.example.datalayer.local.animal.LocalCatImageItemMapper.localCatImageItemToCatImageItem
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class LocalCatImageDataSourceImpl(
    private val localCatImageDao: LocalCatImageDao
) : LocalCatImageDataSource {
    override fun getCatImage(): Single<CatImageEntity> {
        return localCatImageDao
            .getCatImage()
            .subscribeOn(Schedulers.io())
            .map { localCatImageItemToCatImageItem(it) }
    }

    override fun insertCatImage(catImageEntity: CatImageEntity): Completable {
        return localCatImageDao
            .insertCatImage(localCatImageItem = catImageItemToLocalCatImageItem(catImageEntity))
            .subscribeOn(Schedulers.io())
    }

    override fun deleteAllCatImage(): Completable {
        return localCatImageDao
            .deleteAllCatImage()
            .subscribeOn(Schedulers.io())
    }
}