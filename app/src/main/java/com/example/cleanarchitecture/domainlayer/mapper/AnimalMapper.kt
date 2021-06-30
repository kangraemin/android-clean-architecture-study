package com.example.cleanarchitecture.domainlayer.mapper

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import com.example.cleanarchitecture.domainlayer.base.GetDataMapper
import com.example.cleanarchitecture.domainlayer.responsemodel.CatImageResponseModel


object AnimalMapper : GetDataMapper<CatImageItem, CatImageResponseModel> {
    override fun entityToResponseModel(entity: CatImageItem): CatImageResponseModel {
        return CatImageResponseModel(catImageUrl = entity.imageUrl)
    }
}