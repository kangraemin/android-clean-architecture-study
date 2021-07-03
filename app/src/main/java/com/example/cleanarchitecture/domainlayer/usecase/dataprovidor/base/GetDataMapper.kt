package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base

import com.example.datalayer.base.Entity

interface GetDataMapper<E: Entity, RPM: GetDataResponseModel> {
    fun entityToResponseModel(entity: E): RPM
}