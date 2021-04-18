package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.ProductListModel

object DiffUtilsProduct {

    val diffUtilItems = object : DiffUtil.ItemCallback<ProductListModel>() {
        override fun areItemsTheSame(oldItem: ProductListModel, newItem: ProductListModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.title == newItem.title
                    && oldItem.full_title == newItem.full_title
                    && oldItem.images == newItem.images
                    && oldItem.image == newItem.image
                    && oldItem.price == newItem.price
                    && oldItem.old_price == newItem.old_price
                    && oldItem.favorite == newItem.favorite
                    && oldItem.description == newItem.description
                    && oldItem.specification == newItem.specification
                    && oldItem.related_product == newItem.related_product
        }

        override fun areContentsTheSame(oldItem: ProductListModel, newItem: ProductListModel): Boolean {
            return oldItem == newItem
        }
    }
}
