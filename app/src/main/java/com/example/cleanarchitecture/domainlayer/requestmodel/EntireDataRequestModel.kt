package com.example.cleanarchitecture.domainlayer.requestmodel

import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.QuoteRequestModel

data class EntireDataRequestModel(
    val quoteRequestModel: QuoteRequestModel,
    val catImageRequestModel: CatImageRequestModel
)