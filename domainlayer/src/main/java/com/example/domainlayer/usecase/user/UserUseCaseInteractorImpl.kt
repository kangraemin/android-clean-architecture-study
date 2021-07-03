package com.example.domainlayer.usecase.user

import com.example.domainlayer.requestmodel.EntireDataRequestModel
import com.example.domainlayer.responsemodel.EntireDataResponseModel
import com.example.domainlayer.responsemodel.dataprovidor.CatImageResponseModel
import com.example.domainlayer.responsemodel.dataprovidor.QuoteResponseModel
import com.example.domainlayer.usecase.dataprovidor.animal.CatImageUseCaseInteractor
import com.example.domainlayer.usecase.dataprovidor.quote.QuoteUseCaseInteractor
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class UserUseCaseInteractorImpl(
    private val catImageInteractor: CatImageUseCaseInteractor,
    private val quoteInteractor: QuoteUseCaseInteractor
) : UserUseCaseInteractor {

    override fun getEntireData(entireDataRequestModel: EntireDataRequestModel): Single<EntireDataResponseModel> {
        return Single
            .zip(
                quoteInteractor.getData(entireDataRequestModel.quoteRequestModel),
                catImageInteractor.getData(entireDataRequestModel.catImageRequestModel),
                BiFunction { t1: QuoteResponseModel, t2: CatImageResponseModel ->
                    return@BiFunction EntireDataResponseModel(Pair(t1, t2))
                }
            )
    }
}