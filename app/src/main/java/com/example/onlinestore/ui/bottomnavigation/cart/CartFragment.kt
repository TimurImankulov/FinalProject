package com.example.onlinestore.ui.bottomnavigation.cart

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentCartBinding
import com.example.onlinestore.utils.ext.viewBinding
import java.util.*

class CartFragment: BaseFragment() {

    override fun resID() = R.layout.fragment_cart
    private val binding by viewBinding(FragmentCartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCheckout.setOnClickListener {
            navigateToDescription()
        }

        binding.rbCreditCard.setOnClickListener {
            navigateToCard()
        }

//        binding.etDataOfDelivery.setOnClickListener {
//            createDatePickerDialog()
//        }
    }
//    private fun createDatePickerDialog() {
//        val dialog = DatePickerDialog(this)
//        dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
//            etDateOfBirth.setText(getString(R.string.date, dayOfMonth, month, year))
//        }
//        dialog.datePicker.maxDate = Date().time
//        dialog.show()
//    }



    private fun navigateToDescription() {
        val destination = CartFragmentDirections.actionCartFragmentToCheckoutFragment()
        findNavController().navigate(destination)
    }

    private fun navigateToCard() {
        val destination = CartFragmentDirections.actionCartFragmentToCardFragment()
        findNavController().navigate(destination)
    }
}