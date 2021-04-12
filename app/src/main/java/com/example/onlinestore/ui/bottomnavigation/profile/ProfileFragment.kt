package com.example.onlinestore.ui.bottomnavigation.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.local.PreferenceHelper
import com.example.onlinestore.data.model.HistoryOrdersModel
import com.example.onlinestore.databinding.FragmentProfileBinding
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import com.example.onlinestore.utils.ext.viewBinding

class ProfileFragment:BaseFragment() {

    override fun resID() = R.layout.fragment_profile
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val orderAdapter by lazy { OrdersHistoryAdapter(){
        navigateToDetails()
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupView()
    }

    private fun setupView() {
        binding.tvUserName.text = PreferenceHelper.getName().toString()
        binding.tvEmail.text = PreferenceHelper.getEmail().toString()
        binding.tvPhoneNumber.text = PreferenceHelper.getPhoneNumber().toString()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewOrders.adapter = orderAdapter
        orderAdapter.submitList(generateData())

        binding.recyclerViewOrders.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 20f,
                itemRightMargin = 20f,
                itemBottomMargin = 8f
            )
        )
    }

    private fun navigateToDetails() {
        val destination = ProfileFragmentDirections.actionProfileFragmentToOrderFragment()
        findNavController().navigate(destination)
    }

    private fun generateData(): ArrayList<HistoryOrdersModel> {
        val list = arrayListOf<HistoryOrdersModel>()

        list.add(HistoryOrdersModel("№0001", "Done", "Mart27", "$1500", image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"))
        list.add(HistoryOrdersModel("№0002", "Done", "Mart27", "$1500", image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"))
        list.add(HistoryOrdersModel("№0003", "Done", "Mart27", "$1500", image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"))
        list.add(HistoryOrdersModel("№0004", "Done", "Mart27", "$1500", image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"))

        return list
    }
}