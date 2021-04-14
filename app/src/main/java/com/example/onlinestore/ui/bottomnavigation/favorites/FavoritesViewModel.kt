package com.example.onlinestore.ui.bottomnavigation.favorites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.model.ProductListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(private val db: OnlineStoreDataBase): ViewModel() {

    fun update(item: ProductListModel) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getDao().update(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }

    fun getAllFavourites(): LiveData<List<ProductListModel>> {
        return db.getDao().getFavourite()
    }
}