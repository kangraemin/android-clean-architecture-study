package com.example.cleanarchitecture.datalayer.local.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import io.reactivex.Completable
import io.reactivex.Single

interface LocalCatImageDataSource {
    fun getCatImage(): Single<CatImageItem>
    fun insertCatImage(catImageItem: CatImageItem): Completable
    fun deleteAllCatImage(): Completable
}