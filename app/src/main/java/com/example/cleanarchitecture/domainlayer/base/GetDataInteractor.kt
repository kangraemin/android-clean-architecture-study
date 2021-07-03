package com.example.cleanarchitecture.domainlayer.base

import io.reactivex.Single

interface GetDataInteractor<RQM : GetDataRequestModel, RPM : GetDataResponseModel> {
    fun getData(requestModel: RQM): Single<RPM>
}