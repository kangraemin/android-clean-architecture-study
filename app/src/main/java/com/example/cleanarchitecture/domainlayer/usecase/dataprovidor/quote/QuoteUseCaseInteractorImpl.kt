package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.quote

import com.example.cleanarchitecture.datalayer.datagateway.quote.QuoteGateway
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.mapper.QuoteMapper.entityToResponseModel
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.QuoteRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.QuoteResponseModel
import io.reactivex.Single

class QuoteUseCaseInteractorImpl(
    private val quoteGateway: QuoteGateway
) : GetDataInteractor<QuoteRequestModel, QuoteResponseModel> {
    override fun getData(requestModel: QuoteRequestModel): Single<QuoteResponseModel> {
        return quoteGateway
            .getRandomQuote()
            .map { entityToResponseModel(it) }
    }
}