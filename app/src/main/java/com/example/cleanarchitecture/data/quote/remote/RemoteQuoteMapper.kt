package com.example.cleanarchitecture.data.quote.remote

import com.example.cleanarchitecture.data.quote.QuoteItem

object RemoteQuoteMapper {
    fun remoteQuoteItemToQuoteItem(remoteQuoteItem: RemoteQuoteItem) : QuoteItem {
        return QuoteItem(
            quote = remoteQuoteItem.htmlQuoteText,
            author = remoteQuoteItem.author
        )
    }
}