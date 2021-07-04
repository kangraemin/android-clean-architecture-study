package com.example.datalayer.remote.quote

import com.example.datalayer.entity.QuoteEntity
import com.example.datalayer.exception.TooManyRequest

object RemoteQuoteMapper {
    fun remoteQuoteItemToQuoteItem(remoteQuoteItem: RemoteQuoteItem) : QuoteEntity {
        if (remoteQuoteItem.h.contains("Too many requests")) {
            throw TooManyRequest
        }
        return QuoteEntity(
            quote = remoteQuoteItem.h,
            author = remoteQuoteItem.a
        )
    }
}