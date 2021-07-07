package com.example.datalayer.entity

import com.example.datalayer.base.Entity

data class QuoteEntity(
    val quote: String,
    val author: String
) : Entity