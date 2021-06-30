package com.example.cleanarchitecture.datalayer.local.quote

import com.example.cleanarchitecture.datalayer.entity.QuoteItem

object LocalQuoteMapper {
    fun localQuoteItemToQuoteItem(localQuoteItem: LocalQuoteItem): QuoteItem {
        return QuoteItem(
            quote = localQuoteItem.quote,
            author = localQuoteItem.author
        )
    }

    fun quoteItemToLocalQuoteItem(quoteItem: QuoteItem): LocalQuoteItem {
        return LocalQuoteItem(
            quote = quoteItem.quote,
            author = quoteItem.author
        )
    }
}