package com.example.cleanarchitecture.domainlayer.base

import com.example.cleanarchitecture.datalayer.base.Entity

interface GetDataMapper<E: Entity, RPM: GetDataResponseModel> {
    fun catImageEntityToResponseModel(entity: E): RPM
}