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


class CategoryAdapter() : ListAdapter<CategoryModel, CategoryViewHolder>(DiffUtilsItems.diffUtilItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: CategoryModel) {
        itemView.tvCategoryTitle.text = item.title
        itemView.ivCategoryImage.setImageResource(item.image)

//        Picasso.get()
//            .load(item.image)
//            .into(itemView.ivCategory)

    }
}