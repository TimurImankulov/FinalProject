package com.example.onlinestore.ui.productsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.model.ProductListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsVM(private val db: OnlineStoreDataBase) : ViewModel() {

    fun addToCart(details: ProductListModel?) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCart().insert(ModelWrapper.detailsToCart(details))
            }.onFailure {
            }
        }
    }
}