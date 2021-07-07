package com.example.datalayer.datagateway.animal

import com.example.datalayer.entity.CatImageEntity
import com.example.datalayer.local.animal.LocalCatImageDataSource
import com.example.datalayer.remote.animal.RemoteCatImageDataSource
import com.example.datalayer.util.NetworkUtil
import io.reactivex.Single

class CatImageGatewayImpl (
    private val localCatImageDataSource: LocalCatImageDataSource,
    private val remoteCatImageDataSource: RemoteCatImageDataSource,
    private val networkUtil: NetworkUtil
) : CatImageGateway {
    override fun getRandomCatImage(): Single<CatImageEntity> {
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