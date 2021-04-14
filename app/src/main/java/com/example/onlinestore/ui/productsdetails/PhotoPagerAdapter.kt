package com.example.onlinestore.ui.productsdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.Images
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_slide.view.*

class PhotoPagerAdapter(private val listener: (item: Images) -> Unit) : RecyclerView.Adapter<PagerViewHolder>() {

    private val list = arrayListOf<Images>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slide, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun update(list: List<Images>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size
}

class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Images, listener: (item: Images) -> Unit) {

        Picasso.get()
            .load(item.image).into(itemView.iv_Product)

        itemView.card_viewpager.setOnClickListener {
            item.let { listener.invoke(it) }
        }
    }
}
