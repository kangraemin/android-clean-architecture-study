package com.example.cleanarchitecture.domainlayer.usecase.quote

import com.example.cleanarchitecture.datalayer.datagateway.quote.QuoteGateway
import com.example.cleanarchitecture.domainlayer.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.mapper.QuoteMapper.entityToResponseModel
import com.example.cleanarchitecture.domainlayer.requestmodel.QuoteRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.QuoteResponseModel
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