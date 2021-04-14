package com.example.onlinestore.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onlinestore.data.model.CartProductListModel
import com.example.onlinestore.data.model.ItemFavoritesModel
import com.example.onlinestore.data.model.OrderProductListModel
import com.example.onlinestore.data.model.ProductListModel

@Database(entities = [ProductListModel::class, ItemFavoritesModel::class, CartProductListModel::class, OrderProductListModel::class], version = 2)
@TypeConverters(value = [TypeConverter::class])
abstract class OnlineStoreDataBase : RoomDatabase() {
    abstract fun getDao(): OnlineStoreDao
    abstract fun getCart(): CartDao
    abstract fun getOrder(): OrderDao

    companion object {
        fun getInstanceDB(context: Context): OnlineStoreDataBase {
            return Room.databaseBuilder(context, OnlineStoreDataBase::class.java, "myDb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}