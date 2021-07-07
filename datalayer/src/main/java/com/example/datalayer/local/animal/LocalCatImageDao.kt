package com.example.datalayer.local.animal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface LocalCatImageDao {
    @Query(value = "SELECT * FROM catImages LIMIT 1")
    fun getCatImage(): Single<LocalCatImageItem>

    @Insert
    fun insertCatImage(localCatImageItem: LocalCatImageItem): Completable

    @Query(value = "DELETE FROM catImages")
    fun deleteAllCatImage(): Completable
}