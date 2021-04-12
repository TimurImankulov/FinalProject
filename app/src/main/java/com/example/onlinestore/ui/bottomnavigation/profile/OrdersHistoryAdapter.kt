package com.example.onlinestore.ui.bottomnavigation.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.HistoryOrdersModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsOrder
import kotlinx.android.synthetic.main.item_order.view.*
import kotlinx.android.synthetic.main.item_order.view.tv_Price

class OrdersHistoryAdapter(private val listener: () -> Unit) : ListAdapter<HistoryOrdersModel, HistoryOrdersViewHolder>(
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
    fun bind(item: HistoryOrdersModel, listener: () -> Unit) {
        itemView.tv_Number.text = item.number
        itemView.tv_Data.text = item.data
        itemView.tv_Status.text = item.status
        itemView.tv_Price.text = item.price

        itemView.item_order.setOnClickListener {
            listener.invoke()
        }
    }
}