package com.example.onlinestore.ui.bottomnavigation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.test.ProductCategoryModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsItems
import com.example.onlinestore.utils.diffUtils.DiffUtilsTest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val listener: (position: Int, item: ProductCategoryModel) -> Unit) :
    ListAdapter<ProductCategoryModel, CategoryViewHolder>(DiffUtilsTest.diffUtilItems) {

    private var lastSelectedPos = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}

class CategoryViewHolder(view: View, private val listener: (position: Int, item: ProductCategoryModel) -> Unit) :
    RecyclerView.ViewHolder(view) {
    fun bind(item: ProductCategoryModel, position: Int) {
        itemView.tv_CategoryTitle.text = item.category_title
        itemView.category_Card.setOnClickListener {
            listener.invoke(position, item)
            itemView.category_Card.isSelected = true
        }

        Picasso.get()
            .load(item.category_image)
            .into(itemView.iv_CategoryImage)
    }
}