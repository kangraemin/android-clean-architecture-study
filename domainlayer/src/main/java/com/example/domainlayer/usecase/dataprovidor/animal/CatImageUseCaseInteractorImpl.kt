package com.example.domainlayer.usecase.dataprovidor.animal

import com.example.datalayer.datagateway.animal.CatImageGateway
import com.example.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.domainlayer.responsemodel.dataprovidor.CatImageResponseModel
import com.example.domainlayer.usecase.dataprovidor.mapper.AnimalMapper.entityToResponseModel
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
