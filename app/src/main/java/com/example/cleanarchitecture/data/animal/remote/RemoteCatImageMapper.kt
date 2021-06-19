package com.example.cleanarchitecture.data.animal.remote

import com.example.cleanarchitecture.data.animal.CatImageItem

object RemoteCatImageMapper {
    fun remoteCatImageItemToCatImageItem(remoteCatImageItem: RemoteCatImageItem) : CatImageItem {
        return CatImageItem(
            imageUrl = remoteCatImageItem.url
        )
    }
}