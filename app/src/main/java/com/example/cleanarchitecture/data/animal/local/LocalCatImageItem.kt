package com.example.cleanarchitecture.data.animal.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catImages")
data class LocalCatImageItem(
    @PrimaryKey(autoGenerate = true) val idx: Int = 0,
    @ColumnInfo(name = "imageUrl") val imageUrl: String
)