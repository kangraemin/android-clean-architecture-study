package com.example.cleanarchitecture.datalayer.local.quote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class LocalQuoteItem(
    @PrimaryKey(autoGenerate = true) val idx: Int = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)