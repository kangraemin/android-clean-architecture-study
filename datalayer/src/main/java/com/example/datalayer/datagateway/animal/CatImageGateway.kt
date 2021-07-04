package com.example.datalayer.datagateway.animal

import com.example.datalayer.entity.CatImageEntity
import io.reactivex.Single

interface CatImageGateway {
    fun getRandomCatImage(): Single<CatImageEntity>
}