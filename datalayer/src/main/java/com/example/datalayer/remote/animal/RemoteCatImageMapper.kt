package com.example.datalayer.remote.animal

import com.example.datalayer.entity.CatImageItem

object RemoteCatImageMapper {
    fun remoteCatImageItemToCatImageItem(remoteCatImageItem: RemoteCatImageItem) : CatImageItem {
        return CatImageItem(
            imageUrl = remoteCatImageItem.url
        )
    }
}