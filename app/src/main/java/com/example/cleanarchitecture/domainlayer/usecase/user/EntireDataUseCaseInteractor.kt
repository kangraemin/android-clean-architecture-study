package com.example.cleanarchitecture.domainlayer.usecase.user

import com.example.cleanarchitecture.domainlayer.requestmodel.EntireDataRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.EntireDataResponseModel
import io.reactivex.Single

interface EntireDataUseCaseInteractor {
    fun getEntireData(entireDataRequestModel: EntireDataRequestModel): Single<EntireDataResponseModel>
}