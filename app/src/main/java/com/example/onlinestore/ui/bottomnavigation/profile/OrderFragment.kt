package com.example.onlinestore.ui.bottomnavigation.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.HistoryOrdersModel
import com.example.onlinestore.databinding.FragmentOrderBinding
import com.example.onlinestore.utils.ext.viewBinding

class OrderFragment:BaseFragment() {
    override fun resID() = R.layout.fragment_order
    private val binding by viewBinding(FragmentOrderBinding::bind)
    private val args: OrderFragmentArgs by navArgs()

    private val ordersAdapter by lazy { OrdersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewOrders.adapter = ordersAdapter
        ordersAdapter.submitList(generateData())
    }


    private fun generateData(): ArrayList<HistoryOrdersModel> {
        val list = arrayListOf<HistoryOrdersModel>()

        list.add(HistoryOrdersModel("№0001", "Done", "Mart27", "$1500", image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"))
        return list
    }
}