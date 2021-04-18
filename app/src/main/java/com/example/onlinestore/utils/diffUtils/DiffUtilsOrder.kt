package com.example.onlinestore.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinestore.data.model.OrderProductListModel

object DiffUtilsOrder {

    val diffUtilsOrder = object : DiffUtil.ItemCallback<OrderProductListModel>() {
        override fun areItemsTheSame(oldItem: OrderProductListModel, newItem: OrderProductListModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.title == newItem.title
                    && oldItem.full_title == newItem.full_title
                    && oldItem.image == newItem.image
                    && oldItem.price == newItem.price
                    && oldItem.old_price == newItem.old_price
                    && oldItem.favorite == newItem.favorite
                    && oldItem.rank == newItem.rank
                    && oldItem.pickup == newItem.pickup
                    && oldItem.dilivery == newItem.dilivery
                    && oldItem.adress == newItem.adress
                    && oldItem.data == newItem.data
                    && oldItem.creditCard == newItem.creditCard
                    && oldItem.cash == newItem.cash
                    && oldItem.totalSum == newItem.totalSum
                    && oldItem.count == newItem.count
                    && oldItem.description == newItem.description
                    && oldItem.specification == newItem.specification
                    && oldItem.product == newItem.product
                    && oldItem.related_product == newItem.related_product
        }

        override fun areContentsTheSame(oldItem: OrderProductListModel, newItem: OrderProductListModel): Boolean {
            return oldItem == newItem
        }
    }
}

