package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.CategoryModel

object DiffUtilsItems {

    val diffUtilItems = object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.image == newItem.image
                    && oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }
    }
}
