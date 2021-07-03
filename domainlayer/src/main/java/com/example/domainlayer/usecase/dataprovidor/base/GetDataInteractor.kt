package com.example.domainlayer.usecase.dataprovidor.base

import io.reactivex.Single

interface GetDataInteractor<RQM : GetDataRequestModel, RPM : GetDataResponseModel> {
    fun getData(requestModel: RQM): Single<RPM>
}