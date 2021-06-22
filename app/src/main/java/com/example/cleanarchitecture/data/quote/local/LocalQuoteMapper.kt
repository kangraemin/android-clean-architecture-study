package com.example.cleanarchitecture.data.quote.local

import com.example.cleanarchitecture.data.quote.QuoteItem

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