package com.example.datalayer.local.animal

import com.example.datalayer.entity.CatImageEntity

object LocalCatImageItemMapper {
    fun localCatImageItemToCatImageItem(localCatImageItem: LocalCatImageItem): CatImageEntity {
        return CatImageEntity(
            imageUrl = localCatImageItem.imageUrl
        )
    }

    fun catImageItemToLocalCatImageItem(catImageEntity: CatImageEntity): LocalCatImageItem {
        return LocalCatImageItem(
            imageUrl = catImageEntity.imageUrl
        )
    }
}