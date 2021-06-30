package com.example.cleanarchitecture.datalayer.datagateway.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import io.reactivex.Single

interface CatImageGateway {
    fun getRandomCatImage(): Single<CatImageItem>
}