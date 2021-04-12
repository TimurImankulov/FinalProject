package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.test.RelatedProductModel

object DiffUtilsRelatedProduct {

    val diffUtilItems = object : DiffUtil.ItemCallback<RelatedProductModel>() {
        override fun areItemsTheSame(oldItem: RelatedProductModel, newItem: RelatedProductModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: RelatedProductModel, newItem: RelatedProductModel): Boolean {
            return oldItem == newItem
        }
    }
}
