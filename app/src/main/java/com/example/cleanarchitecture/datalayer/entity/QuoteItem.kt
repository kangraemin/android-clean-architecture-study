package com.example.cleanarchitecture.datalayer.entity

import com.example.cleanarchitecture.datalayer.base.Entity

data class QuoteItem(
    val quote: String,
    val author: String
) : Entity