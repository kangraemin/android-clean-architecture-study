package com.example.cleanarchitecture.domainlayer.base

interface GetDataUseCaseInputPort<RQM: GetDataRequestModel> {
    fun getData(requestModel: RQM)
}