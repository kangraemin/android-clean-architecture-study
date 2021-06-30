package com.example.cleanarchitecture.datalayer.remote.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem

object RemoteCatImageMapper {
    fun remoteCatImageItemToCatImageItem(remoteCatImageItem: RemoteCatImageItem) : CatImageItem {
        return CatImageItem(
            imageUrl = remoteCatImageItem.url
        )
    }
}