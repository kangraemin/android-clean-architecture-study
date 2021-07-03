package com.example.domainlayer.requestmodel

import com.example.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.domainlayer.requestmodel.dataprovidor.QuoteRequestModel

data class EntireDataRequestModel(
    val quoteRequestModel: QuoteRequestModel,
    val catImageRequestModel: CatImageRequestModel
)