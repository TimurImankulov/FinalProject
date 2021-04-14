package com.example.onlinestore.data.local


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.onlinestore.data.model.OrderProductListModel

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: OrderProductListModel)

    @Update
    suspend fun update(item: OrderProductListModel)

    @Query("SELECT * FROM orderproductlistmodel WHERE id = :id")
    suspend fun getSingleItem(id: Int): OrderProductListModel?

    @Delete
    suspend fun delete(item: OrderProductListModel)

    @Query("SELECT * FROM orderproductlistmodel")
    fun getAllObservable(): LiveData<List<OrderProductListModel>>
}