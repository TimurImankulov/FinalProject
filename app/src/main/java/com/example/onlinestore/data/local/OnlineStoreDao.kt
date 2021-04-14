package com.example.onlinestore.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.onlinestore.data.model.ProductListModel

@Dao
interface OnlineStoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: ProductListModel)

    @Query("SELECT * FROM productlistmodel")
    fun getAllVacancies(): LiveData<List<ProductListModel>>

    @Update
    fun update(item: ProductListModel)

    @Query("SELECT * FROM ProductListModel WHERE favorite")
    fun getFavourite(): LiveData<List<ProductListModel>>
}

