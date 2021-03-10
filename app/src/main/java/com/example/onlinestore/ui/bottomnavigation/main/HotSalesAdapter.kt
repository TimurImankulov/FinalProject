package com.example.onlinestore.ui.bottomnavigation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsItems
import com.example.onlinestore.utils.ext.setCornerRadius
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_category.view.ivCategoryImage
import kotlinx.android.synthetic.main.item_hotsales.view.*


class HotSalesAdapter() : ListAdapter<CategoryModel, HotSalesViewHolder>(DiffUtilsItems.diffUtilItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotsales, parent, false)
        return HotSalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HotSalesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: CategoryModel) {
        itemView.tvTitle.text = item.title
        itemView.ivHotSales.setImageResource(item.image)

//        Picasso.get()
//            .load(item.image)
//            .into(itemView.ivCategory)

    }
}