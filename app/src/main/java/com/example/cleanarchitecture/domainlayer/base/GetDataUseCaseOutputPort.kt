package com.example.cleanarchitecture.domainlayer.base

import io.reactivex.Single

interface GetDataUseCaseOutputPort<RPM: GetDataResponseModel> {
    fun getData(getCatImageSingle: Single<RPM>)
}