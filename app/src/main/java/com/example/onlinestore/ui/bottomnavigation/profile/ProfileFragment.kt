package com.example.onlinestore.ui.bottomnavigation.profile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.local.PreferenceHelper
import com.example.onlinestore.data.model.OrderProductListModel
import com.example.onlinestore.databinding.FragmentProfileBinding
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment:BaseFragment() {

    override fun resID() = R.layout.fragment_profile
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModel<ProfileViewModel>()
    private val orderAdapter by lazy { OrdersHistoryAdapter(){
        navigateToDetails(it)
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            orderAdapter.submitList(it)
        })
    }

    private fun setupView() {
        binding.tvUserName.text = PreferenceHelper.getName().toString()
        binding.tvEmail.text = PreferenceHelper.getEmail().toString()
        binding.tvPhoneNumber.text = PreferenceHelper.getPhoneNumber().toString()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewOrders.adapter = orderAdapter


        binding.recyclerViewOrders.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 20f,
                itemRightMargin = 20f,
                itemBottomMargin = 8f
            )
        )
    }

    private fun navigateToDetails(data: OrderProductListModel) {
        val destination = ProfileFragmentDirections.actionProfileFragmentToOrderFragment(data)
        findNavController().navigate(destination)
    }
}