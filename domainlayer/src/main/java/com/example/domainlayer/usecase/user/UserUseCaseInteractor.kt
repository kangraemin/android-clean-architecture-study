package com.example.domainlayer.usecase.user

import com.example.domainlayer.requestmodel.EntireDataRequestModel
import com.example.domainlayer.responsemodel.EntireDataResponseModel
import io.reactivex.Single

interface UserUseCaseInteractor {
    fun getEntireData(entireDataRequestModel: EntireDataRequestModel): Single<EntireDataResponseModel>
}