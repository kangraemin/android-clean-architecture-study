package com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor

import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataRequestModel

data class QuoteRequestModel(val unit: Unit) : GetDataRequestModel