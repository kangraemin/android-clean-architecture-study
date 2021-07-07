package com.example.datalayer.remote.animal

import com.example.datalayer.entity.CatImageEntity

object RemoteCatImageMapper {
    fun remoteCatImageItemToCatImageItem(remoteCatImageItem: RemoteCatImageItem) : CatImageEntity {
        return CatImageEntity(
            imageUrl = remoteCatImageItem.url
        )
    }
}