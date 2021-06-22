package com.example.cleanarchitecture.data.animal.local

import com.example.cleanarchitecture.data.animal.CatImageItem

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