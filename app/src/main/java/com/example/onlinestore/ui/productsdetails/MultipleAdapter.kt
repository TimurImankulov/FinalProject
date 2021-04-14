package com.example.onlinestore.ui.productsdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.data.model.ListSpecificationsModel
import com.example.onlinestore.data.model.Specification
import com.example.onlinestore.databinding.ItemHeaderBinding
import com.example.onlinestore.databinding.ItemSpecificationBinding


class MultipleAdapter : RecyclerView.Adapter<HeaderViewHolder>() {

    private val list = arrayListOf<Specification>()

    fun update(list: List<Specification>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}


class HeaderViewHolder(private val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    private val adapter = SpecificationsAdapter()

    init {
        binding.recyclerViewProductSpecification.adapter = adapter
    }

    fun bind(response: Specification) {
        binding.tvHeader.text = response.header
        adapter.update(response.list_specification)
    }

    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            val binding =
                ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return HeaderViewHolder(binding)
        }
    }
}

class SpecificationsAdapter : RecyclerView.Adapter<SpecificationsViewHolder>(){

    private val list = arrayListOf<ListSpecificationsModel>()

    fun update(list: List<ListSpecificationsModel>?) {
        this.list.clear()
        this.list.addAll(ArrayList(list))
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationsViewHolder {
        return SpecificationsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SpecificationsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class SpecificationsViewHolder(private val binding: ItemSpecificationBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(specifications: ListSpecificationsModel) {
        binding.tvDetails.text = specifications.value
        binding.tvTitle.text = specifications.title
    }

    companion object {
        fun create(parent: ViewGroup): SpecificationsViewHolder {
            val binding =
                ItemSpecificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return SpecificationsViewHolder(binding)
        }
    }
}