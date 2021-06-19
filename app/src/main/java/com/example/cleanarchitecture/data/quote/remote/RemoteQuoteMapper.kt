package com.example.cleanarchitecture.data.quote.remote

import com.example.cleanarchitecture.data.quote.QuoteItem
import com.example.cleanarchitecture.exception.TooManyRequest

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