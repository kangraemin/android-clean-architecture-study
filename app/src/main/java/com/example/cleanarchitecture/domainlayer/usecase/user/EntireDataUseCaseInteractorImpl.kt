package com.example.cleanarchitecture.domainlayer.usecase.user

import com.example.cleanarchitecture.domainlayer.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.requestmodel.CatImageRequestModel
import com.example.cleanarchitecture.domainlayer.requestmodel.EntireDataRequestModel
import com.example.cleanarchitecture.domainlayer.requestmodel.QuoteRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.CatImageResponseModel
import com.example.cleanarchitecture.domainlayer.responsemodel.EntireDataResponseModel
import com.example.cleanarchitecture.domainlayer.responsemodel.QuoteResponseModel
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class EntireDataUseCaseInteractorImpl(
    private val catImageInteractor: GetDataInteractor<CatImageRequestModel, CatImageResponseModel>,
    private val quoteInteractor: GetDataInteractor<QuoteRequestModel, QuoteResponseModel>
) : EntireDataUseCaseInteractor {

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