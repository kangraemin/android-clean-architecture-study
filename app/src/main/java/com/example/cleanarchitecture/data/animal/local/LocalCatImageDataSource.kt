package com.example.cleanarchitecture.data.animal.local

import com.example.cleanarchitecture.data.animal.CatImageItem
import io.reactivex.Completable
import io.reactivex.Single

interface LocalCatImageDataSource {
    fun getCatImage(): Single<CatImageItem>
    fun insertCatImage(catImageItem: CatImageItem): Completable
    fun deleteAllCatImage(): Completable
}