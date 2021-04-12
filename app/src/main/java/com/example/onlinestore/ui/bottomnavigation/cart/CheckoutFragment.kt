package com.example.onlinestore.ui.bottomnavigation.cart

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentCartBinding
import com.example.onlinestore.databinding.FragmentCheckoutBinding
import com.example.onlinestore.utils.ext.viewBinding
import kotlinx.android.synthetic.main.fragment_checkout.*

class CheckoutFragment: BaseFragment() {
    override fun resID() = R.layout.fragment_checkout
    private val binding by viewBinding(FragmentCheckoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCheckout.setOnClickListener {
            navigateToCard()
        }
    }

    private fun navigateToCard() {
        val destination = CheckoutFragmentDirections.actionCheckoutFragmentToCardFragment()
        findNavController().navigate(destination)
    }
}