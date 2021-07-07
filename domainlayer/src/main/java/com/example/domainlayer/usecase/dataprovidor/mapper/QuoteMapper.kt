package com.example.domainlayer.usecase.dataprovidor.mapper

import com.example.datalayer.entity.QuoteEntity
import com.example.domainlayer.usecase.dataprovidor.base.GetDataMapper
import com.example.domainlayer.responsemodel.dataprovidor.QuoteResponseModel

object QuoteMapper : GetDataMapper<QuoteEntity, QuoteResponseModel> {
    override fun entityToResponseModel(entity: QuoteEntity): QuoteResponseModel {
        return QuoteResponseModel(
            quote = entity.quote
        )
    }
}