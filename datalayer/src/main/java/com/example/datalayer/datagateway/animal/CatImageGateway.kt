package com.example.datalayer.datagateway.animal

import com.example.datalayer.entity.CatImageItem
import io.reactivex.Single

interface CatImageGateway {
    fun getRandomCatImage(): Single<CatImageItem>
}