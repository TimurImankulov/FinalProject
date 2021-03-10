package com.example.onlinestore.ui.bottomnavigation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsItems
import kotlinx.android.synthetic.main.item_bestsales.view.*

class BestSellerAdapter() : ListAdapter<CategoryModel, BestSellerViewHolder>(DiffUtilsItems.diffUtilItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bestsales, parent, false)
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: CategoryModel) {
        itemView.tvTitle.text = item.title
        itemView.ivBestSales.setImageResource(item.image)

//        Picasso.get()
//            .load(item.image)
//            .into(itemView.ivCategory)

    }
}