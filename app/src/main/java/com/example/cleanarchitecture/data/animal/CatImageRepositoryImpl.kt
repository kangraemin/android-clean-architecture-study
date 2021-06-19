package com.example.cleanarchitecture.data.animal

import com.example.cleanarchitecture.data.animal.local.LocalCatImageDataSource
import com.example.cleanarchitecture.data.animal.remote.RemoteCatImageDataSource
import com.example.cleanarchitecture.util.NetworkUtil
import io.reactivex.Single

class CatImageRepositoryImpl (
    private val localCatImageDataSource: LocalCatImageDataSource,
    private val remoteCatImageDataSource: RemoteCatImageDataSource,
    private val networkUtil: NetworkUtil
) : CatImageRepository {
    override fun getRandomCatImage(): Single<CatImageItem> {
        return Single
            .defer {
                if (!networkUtil.isNetworkConnected()) {
                    return@defer localCatImageDataSource
                        .getCatImage()
                } else {
                    return@defer remoteCatImageDataSource
                        .getRandomCatImage()
                        .flatMap { catImageItem ->
                            localCatImageDataSource
                                .deleteAllCatImage()
                                .andThen(localCatImageDataSource.insertCatImage(catImageItem))
                                .toSingleDefault(catImageItem)
                        }
                }
            }
    }
}