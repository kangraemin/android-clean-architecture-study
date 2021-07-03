package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.animal

import com.example.cleanarchitecture.datalayer.datagateway.animal.CatImageGateway
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.CatImageResponseModel
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.mapper.AnimalMapper.entityToResponseModel
import io.reactivex.Single

class CatImageUseCaseInteractorImpl(
    private val catImageGateway: CatImageGateway
) : CatImageUseCaseInteractor {
    override fun getData(requestModel: CatImageRequestModel): Single<CatImageResponseModel> {
        return catImageGateway
            .getRandomCatImage()
            .map { entityToResponseModel(it) }
    }
}
