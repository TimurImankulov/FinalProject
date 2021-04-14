package com.example.onlinestore.data.local


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.onlinestore.data.test.CartProductListModel

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartProductListModel)

    @Update
    suspend fun update(item: CartProductListModel)

    @Query("SELECT * FROM cartproductlistmodel WHERE id = :id")
    suspend fun getSingleItem(id: Int): CartProductListModel?

    @Delete
    suspend fun delete(item: CartProductListModel)

    @Query("SELECT * FROM cartproductlistmodel")
    fun getAllObservable(): LiveData<List<CartProductListModel>>
}