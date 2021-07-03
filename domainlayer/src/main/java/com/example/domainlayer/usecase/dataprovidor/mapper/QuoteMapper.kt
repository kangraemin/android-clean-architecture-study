package com.example.domainlayer.usecase.dataprovidor.mapper

import com.example.datalayer.entity.QuoteItem
import com.example.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.domainlayer.responsemodel.dataprovidor.QuoteResponseModel

object QuoteMapper : GetDataMapper<QuoteItem, QuoteResponseModel> {
    override fun entityToResponseModel(entity: QuoteItem): QuoteResponseModel {
        return QuoteResponseModel(
            quote = entity.quote
        )
    }
}