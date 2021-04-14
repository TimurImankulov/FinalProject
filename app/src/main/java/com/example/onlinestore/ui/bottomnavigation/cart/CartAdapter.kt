package com.example.onlinestore.ui.bottomnavigation.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CartProductListModel
import com.example.onlinestore.utils.diffUtils.DiffUtilsCart
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cart.view.*
import kotlinx.android.synthetic.main.item_favorite_product.view.iv_Product

class CartAdapter(private val listener: (item: CartProductListModel) -> Unit) :
    ListAdapter<CartProductListModel, CartViewHolder>(
        DiffUtilsCart.diffUtilItems
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: CartProductListModel, listener: (item: CartProductListModel) -> Unit) {
        itemView.tv_ProductName.text = item.title
        itemView.tv_ProductPrice.text = item.price

        itemView.btn_Delete.setOnClickListener {
            listener.invoke(item)
        }

        Picasso.get()
            .load(item.image)
            .into(itemView.iv_Product)
    }
}