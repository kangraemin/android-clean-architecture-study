package com.example.cleanarchitecture.domainlayer.usecase.animal

import com.example.cleanarchitecture.datalayer.datagateway.animal.CatImageGateway
import com.example.cleanarchitecture.domainlayer.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.mapper.AnimalMapper.entityToResponseModel
import com.example.cleanarchitecture.domainlayer.requestmodel.CatImageRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.CatImageResponseModel
import io.reactivex.Single

class CatImageUseCaseInteractorImpl(
    private val catImageGateway: CatImageGateway
) : GetDataInteractor<CatImageRequestModel, CatImageResponseModel> {
    override fun getData(requestModel: CatImageRequestModel): Single<CatImageResponseModel> {
        return catImageGateway
            .getRandomCatImage()
            .map { entityToResponseModel(it) }
    }
}
