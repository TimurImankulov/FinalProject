package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.ProductListModel

object DiffUtilsBestSales {

    val diffUtilItems = object : DiffUtil.ItemCallback<ProductListModel>() {
        override fun areItemsTheSame(oldItem: ProductListModel, newItem: ProductListModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ProductListModel, newItem: ProductListModel): Boolean {
            return oldItem == newItem
        }
    }
}
