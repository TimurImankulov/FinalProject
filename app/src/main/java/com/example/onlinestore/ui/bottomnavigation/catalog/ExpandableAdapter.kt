package com.example.onlinestore.ui.bottomnavigation.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CatalogModel
import com.example.onlinestore.data.model.ProductListModel


class ExpandableAdapter(private val listener: (list: List<ProductListModel>?) -> Unit) : BaseExpandableListAdapter() {

    private val list = arrayListOf<CatalogModel>()

    fun update(list: List<CatalogModel>?) {
        this.list.clear()
        list?.let { this.list.addAll(it) }
        notifyDataSetChanged()
    }

    override fun getGroupCount() = list.size

    override fun getChildrenCount(groupPosition: Int) = list[groupPosition].catalog_items?.size ?:0

    override fun getGroup(groupPosition: Int) = list[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int) =
        list[groupPosition].catalog_items?.get(childPosition)

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun hasStableIds() = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {



        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_exp_parent, parent, false)
        }
        view?.findViewById<TextView>(R.id.tv_Title)?.text = list[groupPosition].title
        view?.findViewById<ImageView>(R.id.ivGroupIndicator)?.isSelected = isExpanded
        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?,
    ): View? {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_exp_child, parent, false)

        }

        val item = list[groupPosition].catalog_items?.get(childPosition)
        view?.findViewById<TextView>(R.id.tv_Title)?.text =
            item?.title
        view?.setOnClickListener {
            listener.invoke(item?.product_list)
        }

        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}