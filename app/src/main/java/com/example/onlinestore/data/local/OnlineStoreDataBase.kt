package com.example.onlinestore.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onlinestore.data.test.ItemFavoritesModel
import com.example.onlinestore.data.test.ProductListModel

@Database(entities = [ProductListModel::class, ItemFavoritesModel::class], version = 1)
@TypeConverters(value = [TypeConverter::class])
abstract class OnlineStoreDataBase : RoomDatabase() {
    abstract fun getDao(): OnlineStoreDao

    companion object {
        fun getInstanceDB(context: Context): OnlineStoreDataBase {
            return Room.databaseBuilder(context, OnlineStoreDataBase::class.java, "myDb")
                .allowMainThreadQueries()
                .build()
        }
    }
}