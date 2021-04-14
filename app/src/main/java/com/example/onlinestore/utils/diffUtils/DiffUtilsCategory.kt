package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.ProductCategoryModel

object DiffUtilsCategory {

    val diffUtilItems = object : DiffUtil.ItemCallback<ProductCategoryModel>() {
        override fun areItemsTheSame(oldItem: ProductCategoryModel, newItem: ProductCategoryModel): Boolean {
            return oldItem.category_image == newItem.category_image
        }

        override fun areContentsTheSame(oldItem: ProductCategoryModel, newItem: ProductCategoryModel): Boolean {
            return oldItem == newItem
        }
    }
}
