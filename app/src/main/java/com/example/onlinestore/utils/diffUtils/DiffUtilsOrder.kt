package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.model.HistoryOrdersModel
import com.example.onlinestore.data.test.OrderProductListModel

object DiffUtilsOrder {

    val diffUtilsOrder = object : DiffUtil.ItemCallback<OrderProductListModel>() {
        override fun areItemsTheSame(oldItem: OrderProductListModel, newItem: OrderProductListModel): Boolean {
            return oldItem.data == newItem.data
                    && oldItem.price == newItem.price
        }

        override fun areContentsTheSame(oldItem: OrderProductListModel, newItem: OrderProductListModel): Boolean {
            return oldItem == newItem
        }
    }
}
