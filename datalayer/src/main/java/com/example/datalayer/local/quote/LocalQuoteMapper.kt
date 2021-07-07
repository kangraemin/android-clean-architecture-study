package com.example.datalayer.local.quote

import com.example.datalayer.entity.QuoteEntity

object LocalQuoteMapper {
    fun localQuoteItemToQuoteItem(localQuoteItem: LocalQuoteItem): QuoteEntity {
        return QuoteEntity(
            quote = localQuoteItem.quote,
            author = localQuoteItem.author
        )
    }

    fun quoteItemToLocalQuoteItem(quoteEntity: QuoteEntity): LocalQuoteItem {
        return LocalQuoteItem(
            quote = quoteEntity.quote,
            author = quoteEntity.author
        )
    }
}