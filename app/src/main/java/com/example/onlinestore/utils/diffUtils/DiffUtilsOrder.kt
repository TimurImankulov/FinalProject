package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.model.HistoryOrdersModel

object DiffUtilsOrder {

    val diffUtilsOrder = object : DiffUtil.ItemCallback<HistoryOrdersModel>() {
        override fun areItemsTheSame(oldItem: HistoryOrdersModel, newItem: HistoryOrdersModel): Boolean {
            return oldItem.number == newItem.number
                    && oldItem.status == newItem.status
                    && oldItem.data == newItem.data
                    && oldItem.price == newItem.price
        }

        override fun areContentsTheSame(oldItem: HistoryOrdersModel, newItem: HistoryOrdersModel): Boolean {
            return oldItem == newItem
        }
    }
}
