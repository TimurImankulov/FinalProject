package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.test.Images

object DiffUtilsImages {

    val diffUtilItems = object : DiffUtil.ItemCallback<Images>() {
        override fun areItemsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem == newItem
        }
    }
}
