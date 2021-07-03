package com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.mapper

import com.example.datalayer.entity.QuoteItem
import com.example.cleanarchitecture.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.cleanarchitecture.domainlayer.responsemodel.dataprovidor.QuoteResponseModel

object QuoteMapper : GetDataMapper<QuoteItem, QuoteResponseModel> {
    override fun entityToResponseModel(entity: QuoteItem): QuoteResponseModel {
        return QuoteResponseModel(
            quote = entity.quote
        )
    }
}