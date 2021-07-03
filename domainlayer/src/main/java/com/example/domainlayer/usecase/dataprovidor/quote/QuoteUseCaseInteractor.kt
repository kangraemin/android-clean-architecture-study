package com.example.domainlayer.usecase.dataprovidor.quote

import com.example.domainlayer.requestmodel.dataprovidor.QuoteRequestModel
import com.example.domainlayer.responsemodel.dataprovidor.QuoteResponseModel
import com.example.domainlayer.usecase.dataprovidor.base.GetDataInteractor

interface QuoteUseCaseInteractor : GetDataInteractor<QuoteRequestModel, QuoteResponseModel>