package com.example.cleanarchitecture.datalayer.remote.animal

data class RemoteCatImageItem(
    val breeds: List<Any>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)