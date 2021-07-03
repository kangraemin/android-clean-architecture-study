package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.mapper

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.CatImageResponseModel


object AnimalMapper : GetDataMapper<CatImageItem, CatImageResponseModel> {
    override fun entityToResponseModel(entity: CatImageItem): CatImageResponseModel {
        return CatImageResponseModel(
            catImageUrl = entity.imageUrl
        )
    }
}