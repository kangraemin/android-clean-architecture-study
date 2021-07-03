package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.quote

import com.example.datalayer.datagateway.quote.QuoteGateway
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.QuoteRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.QuoteResponseModel
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.mapper.QuoteMapper.entityToResponseModel
import io.reactivex.Single

class QuoteUseCaseInteractorImpl(
    private val quoteGateway: QuoteGateway
) : QuoteUseCaseInteractor {

    override fun getData(requestModel: QuoteRequestModel): Single<QuoteResponseModel> {
        return quoteGateway
            .getRandomQuote()
            .map { entityToResponseModel(it) }
    }
}