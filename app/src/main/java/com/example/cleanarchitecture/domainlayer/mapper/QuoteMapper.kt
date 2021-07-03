package com.example.cleanarchitecture.domainlayer.mapper

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import com.example.cleanarchitecture.domainlayer.base.GetDataMapper
import com.example.cleanarchitecture.domainlayer.responsemodel.QuoteResponseModel

object QuoteMapper : GetDataMapper<QuoteItem, QuoteResponseModel> {
    override fun entityToResponseModel(entity: QuoteItem): QuoteResponseModel {
        return QuoteResponseModel(quote = entity.quote)
    }
}