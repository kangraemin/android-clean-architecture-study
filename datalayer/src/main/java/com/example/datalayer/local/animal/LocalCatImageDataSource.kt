package com.example.datalayer.local.animal

import com.example.datalayer.entity.CatImageEntity
import io.reactivex.Completable
import io.reactivex.Single

interface LocalCatImageDataSource {
    fun getCatImage(): Single<CatImageEntity>
    fun insertCatImage(catImageEntity: CatImageEntity): Completable
    fun deleteAllCatImage(): Completable
}