package com.example.onlinestore.ui.relatedproductdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.model.RelatedProductModel
import com.example.onlinestore.ui.productsdetails.ModelWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RelatedProductVM(private val db: OnlineStoreDataBase) : ViewModel() {

    fun addToCart(details: RelatedProductModel?) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCart().insert(ModelWrapper.detailsToRelatedProduct(details))
            }.onFailure {
            }
        }
    }
}