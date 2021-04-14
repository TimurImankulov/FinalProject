package com.example.onlinestore.ui.productsdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.RelatedProductModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsRelatedProduct
import com.example.onlinestore.utils.ext.strikeThroughSpan
import kotlinx.android.synthetic.main.item_related_product.view.hotsales_ProductCard
import kotlinx.android.synthetic.main.item_related_product.view.tv_OldPrice
import kotlinx.android.synthetic.main.item_related_product.view.tv_Price
import kotlinx.android.synthetic.main.item_related_product.view.tv_Title

class RelatedProductAdapter(private val listener: (item: RelatedProductModel) -> Unit) : ListAdapter<RelatedProductModel, RelatedProductViewHolder>(DiffUtilsRelatedProduct.diffUtilItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_related_product, parent, false)
        return RelatedProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatedProductViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class RelatedProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: RelatedProductModel, listener: (item: RelatedProductModel) -> Unit) {
        itemView.tv_Title.text = item.title
        itemView.tv_Price.text = item.priceNew
        itemView.tv_OldPrice.text = item.old_price?.strikeThroughSpan()

        itemView.hotsales_ProductCard.setOnClickListener {
              listener.invoke(item)
        }
    }
}