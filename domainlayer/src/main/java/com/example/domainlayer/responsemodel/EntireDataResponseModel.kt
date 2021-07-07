package com.example.domainlayer.responsemodel

import com.example.domainlayer.responsemodel.dataprovidor.CatImageResponseModel
import com.example.domainlayer.responsemodel.dataprovidor.QuoteResponseModel

data class EntireDataResponseModel(val entireData: Pair<QuoteResponseModel, CatImageResponseModel>)