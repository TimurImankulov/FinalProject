package com.example.onlinestore.ui.bottomnavigation.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.OrderProductListModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsOrder
import kotlinx.android.synthetic.main.item_order.view.*
import kotlin.random.Random

class OrdersHistoryAdapter(private val listener: (item:OrderProductListModel) -> Unit) : ListAdapter<OrderProductListModel, HistoryOrdersViewHolder>(
    DiffUtilsOrder.diffUtilsOrder) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryOrdersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return HistoryOrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryOrdersViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class HistoryOrdersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: OrderProductListModel, listener: (item: OrderProductListModel) -> Unit) {
        itemView.tv_OrderNumber.text = Random.nextInt(1000,100000).toString()
        itemView.tv_OrderData.text = item.data
        itemView.tv_TotalSum.text = item.totalSum.toString()

        itemView.item_order.setOnClickListener {
            listener.invoke(item)
        }
    }
}