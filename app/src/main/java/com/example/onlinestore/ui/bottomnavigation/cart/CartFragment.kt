package com.example.onlinestore.ui.bottomnavigation.cart

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentCartBinding
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class CartFragment : BaseFragment() {

    override fun resID() = R.layout.fragment_cart
    private val binding by viewBinding(FragmentCartBinding::bind)
    private val vm by viewModel<CartViewModel>()
    private val cartAdapter by lazy {
        CartAdapter() {
            vm.deleteItem(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupViewModel()
        setupRecyclerView()
        setupViews()
    }

    private fun setupViews() {
        vm.totalSumm.observe(viewLifecycleOwner, {
            binding.tvPrice.text = it.toString()
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCart.adapter = cartAdapter
    }

    private fun setupViewModel() {
        vm.getData().observe(viewLifecycleOwner, {
            cartAdapter.submitList(it)
            vm.totalSum(it)
        })
    }

    private fun setupListeners() {

        binding.rbCreditCard.setOnClickListener {
            navigateToCard()
        }

        binding.etDataOfDelivery.setOnClickListener {
            createDatePickerDialog()
        }

        binding.btnCheckout.setOnClickListener {
            val statePickup = binding.rbPickup.isChecked
            val stateDelivery = binding.rbDelivery.isChecked
            val adress = binding.etDeliveryAddress.text
            val deliveryData = binding.etDataOfDelivery.text
            val stateCreditCard = binding.rbCreditCard.isChecked
            val stateCash = binding.rbCashPayment.isChecked

            vm.createOrder(
                statePickup,
                stateDelivery,
                adress,
                deliveryData,
                stateCreditCard,
                stateCash
            )

            createCustomDialog()
        }
    }


    private fun createDatePickerDialog() {
        val dialog = DatePickerDialog(requireContext())
        dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            binding.etDataOfDelivery.setText(getString(R.string.date, dayOfMonth, month, year))
        }
        dialog.datePicker.minDate = Date().time
        dialog.show()
    }

    private fun createCustomDialog() {
        CustomDialog(requireContext()).show()
    }

    private fun navigateToCard() {
        val destination = CartFragmentDirections.actionCartFragmentToCardFragment()
        findNavController().navigate(destination)
    }
}
