package com.example.cleanarchitecture.datalayer.remote.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem
import com.example.cleanarchitecture.datalayer.exception.TooManyRequest

object RemoteQuoteMapper {
    fun remoteQuoteItemToQuoteItem(remoteQuoteItem: RemoteQuoteItem) : QuoteItem {
        if (remoteQuoteItem.h.contains("Too many requests")) {
            throw TooManyRequest
        }
        return QuoteItem(
            quote = remoteQuoteItem.h,
            author = remoteQuoteItem.a
        )
    }
}