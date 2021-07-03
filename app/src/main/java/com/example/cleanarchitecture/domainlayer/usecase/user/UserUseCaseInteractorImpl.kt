package com.example.cleanarchitecture.domainlayer.usecase.user

import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataInteractor
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.CatImageRequestModel
import com.example.cleanarchitecture.domainlayer.requestmodel.EntireDataRequestModel
import com.example.cleanarchitecture.domainlayer.requestmodel.dataprovidor.QuoteRequestModel
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.CatImageResponseModel
import com.example.cleanarchitecture.domainlayer.responsemodel.EntireDataResponseModel
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.QuoteResponseModel
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class UserUseCaseInteractorImpl(
    private val catImageInteractor: GetDataInteractor<CatImageRequestModel, CatImageResponseModel>,
    private val quoteInteractor: GetDataInteractor<QuoteRequestModel, QuoteResponseModel>
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