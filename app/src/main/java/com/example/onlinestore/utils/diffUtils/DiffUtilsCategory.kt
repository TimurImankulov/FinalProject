package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.ProductCategoryModel

object DiffUtilsCategory {

    val diffUtilItems = object : DiffUtil.ItemCallback<ProductCategoryModel>() {
        override fun areItemsTheSame(oldItem: ProductCategoryModel, newItem: ProductCategoryModel): Boolean {
            return oldItem.category_image == newItem.category_image
                    && oldItem.bestsales_title == newItem.bestsales_title
                    && oldItem.bestsales_description == newItem.bestsales_description
                    && oldItem.bestsales_image == newItem.bestsales_image
                    && oldItem.category_title == newItem.category_title
                    && oldItem.items == newItem.items
        }

        override fun areContentsTheSame(oldItem: ProductCategoryModel, newItem: ProductCategoryModel): Boolean {
            return oldItem == newItem
        }
    }
}
