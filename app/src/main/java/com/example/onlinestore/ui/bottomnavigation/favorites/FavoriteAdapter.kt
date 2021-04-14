package com.example.onlinestore.ui.bottomnavigation.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.ProductListModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsBestSales
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_favorite_product.view.*

class FavoriteAdapter(private val listener: () -> Unit) :
    ListAdapter<ProductListModel, FavoriteViewHolder>(
        DiffUtilsBestSales.diffUtilItems
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_product, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: ProductListModel, listener: () -> Unit) {
        itemView.tv_Title.text = item.full_title

        Picasso.get()
            .load(item.image)
            .into(itemView.iv_Product)


        itemView.item_favorite.setOnClickListener {
            listener.invoke()
        }
    }
}