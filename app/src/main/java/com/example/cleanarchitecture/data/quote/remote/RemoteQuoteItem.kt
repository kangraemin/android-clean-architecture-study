package com.example.cleanarchitecture.data.quote.remote

data class RemoteQuoteItem(
    val author: String, // Author
    val htmlQuoteText: String, // pre-formatted HTML
    val quote: String // quote text
)