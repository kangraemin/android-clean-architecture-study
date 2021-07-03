package com.example.datalayer.remote.quote

import com.example.datalayer.entity.QuoteItem
import com.example.datalayer.exception.TooManyRequest

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