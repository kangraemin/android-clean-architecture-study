package com.example.domainlayer.usecase.dataprovidor.mapper

import com.example.datalayer.entity.CatImageItem
import com.example.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.domainlayer.responsemodel.dataprovidor.CatImageResponseModel


object AnimalMapper : GetDataMapper<CatImageItem, CatImageResponseModel> {
    override fun entityToResponseModel(entity: CatImageItem): CatImageResponseModel {
        return CatImageResponseModel(
            catImageUrl = entity.imageUrl
        )
    }
}