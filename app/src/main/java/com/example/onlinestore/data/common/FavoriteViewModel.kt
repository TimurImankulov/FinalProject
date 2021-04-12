package com.example.onlinestore.data.common

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.test.ProductListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class FavoriteViewModel(private val db:OnlineStoreDataBase):ViewModel() {

    fun update(item: ProductListModel) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getDao().insert(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }
}