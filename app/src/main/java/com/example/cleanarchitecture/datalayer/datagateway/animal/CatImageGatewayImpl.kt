package com.example.cleanarchitecture.datalayer.datagateway.animal

import com.example.cleanarchitecture.datalayer.entity.CatImageItem
import com.example.cleanarchitecture.datalayer.local.animal.LocalCatImageDataSource
import com.example.cleanarchitecture.datalayer.remote.animal.RemoteCatImageDataSource
import com.example.cleanarchitecture.presentationlayer.util.NetworkUtil
import io.reactivex.Single

class CatImageGatewayImpl (
    private val localCatImageDataSource: LocalCatImageDataSource,
    private val remoteCatImageDataSource: RemoteCatImageDataSource,
    private val networkUtil: NetworkUtil
) : CatImageGateway {
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