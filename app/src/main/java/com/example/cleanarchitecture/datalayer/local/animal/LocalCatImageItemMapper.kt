package com.example.cleanarchitecture.datalayer.local.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem

object LocalCatImageItemMapper {
    fun localCatImageItemToCatImageItem(localCatImageItem: LocalCatImageItem): CatImageItem {
        return CatImageItem(
            imageUrl = localCatImageItem.imageUrl
        )
    }

    fun catImageItemToLocalCatImageItem(catImageItem: CatImageItem): LocalCatImageItem {
        return LocalCatImageItem(
            imageUrl = catImageItem.imageUrl
        )
    }
}