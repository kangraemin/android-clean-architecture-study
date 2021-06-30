package com.example.cleanarchitecture.domainlayer.usecase.animal

import com.example.cleanarchitecture.datalayer.datagateway.animal.CatImageGateway
import com.example.cleanarchitecture.domainlayer.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.mapper.AnimalMapper.entityToResponseModel
import com.example.cleanarchitecture.domainlayer.requestmodel.CatImageRequestModel

class CatImageUseCaseInteractor(
    private val catImageGateway: CatImageGateway,
    private val catImageUseCaseOutputPort: CatImageUseCaseOutputPort
) : GetDataInteractor<CatImageRequestModel> {
    override fun getData(requestModel: CatImageRequestModel) {
        catImageUseCaseOutputPort.getData(
            catImageGateway
                .getRandomCatImage()
                .map { entityToResponseModel(it) }
        )
    }
}
