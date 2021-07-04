package com.example.domainlayer.usecase.dataprovidor.mapper

import com.example.datalayer.entity.CatImageEntity
import com.example.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.domainlayer.responsemodel.dataprovidor.CatImageResponseModel


object AnimalMapper : GetDataMapper<CatImageEntity, CatImageResponseModel> {
    override fun entityToResponseModel(entity: CatImageEntity): CatImageResponseModel {
        return CatImageResponseModel(
            catImageUrl = entity.imageUrl
        )
    }
}