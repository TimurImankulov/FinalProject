package com.example.onlinestore.ui.bottomnavigation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.ProductListModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsProduct
import com.example.onlinestore.utils.ext.strikeThroughSpan
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_product.view.*

class ProductCategoryAdapter(
    private val listener: (item: ProductListModel) -> Unit
) : ListAdapter<ProductListModel, ProductCategoryViewHolder>(DiffUtilsProduct.diffUtilItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class ProductCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        item: ProductListModel,
        listener: (item: ProductListModel) -> Unit
    ) {
        itemView.tv_Title.text = item.title
        itemView.tv_Price.text = item.price
        itemView.tv_OldPrice.text = item.old_price.toString().strikeThroughSpan()

        Picasso.get()
            .load(item.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(itemView.iv_Product)

        itemView.hotsales_ProductCard.setOnClickListener {
            listener.invoke(item)
        }
    }
}