package com.example.onlinestore.ui.bottomnavigation.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.OrderProductListModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsOrder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bought_product.view.*

class OrdersAdapter : ListAdapter<OrderProductListModel, RelatedProductViewHolder>(DiffUtilsOrder.diffUtilsOrder) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bought_product, parent, false)
        return RelatedProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatedProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RelatedProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: OrderProductListModel) {
        itemView.tv_Title.text = item.title
        itemView.tv_Price.text = "1500"

        Picasso.get()
            .load(item.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(itemView.iv_Product)
    }
}