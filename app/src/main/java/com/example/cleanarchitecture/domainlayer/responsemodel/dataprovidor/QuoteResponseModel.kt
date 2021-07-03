package com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor

import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataResponseModel

data class QuoteResponseModel(val quote: String) : GetDataResponseModel