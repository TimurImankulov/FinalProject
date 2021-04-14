package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.test.CartProductListModel
import com.example.onlinestore.data.test.ProductListModel

object DiffUtilsCart {

    val diffUtilItems = object : DiffUtil.ItemCallback<CartProductListModel>() {
        override fun areItemsTheSame(oldItem: CartProductListModel, newItem: CartProductListModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: CartProductListModel, newItem: CartProductListModel): Boolean {
            return oldItem == newItem
        }
    }
}
