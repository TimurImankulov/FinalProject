package com.example.onlinestore.ui.bottomnavigation.cart

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.ActivityLoginBinding.bind
import com.example.onlinestore.databinding.FragmentCardBinding
import com.example.onlinestore.databinding.FragmentCartBinding
import com.example.onlinestore.utils.ext.viewBinding
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment: BaseFragment()  {
    override fun resID() = R.layout.fragment_card
    private val binding by viewBinding(FragmentCardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         setupListeners()
        val s = et_CardNumber.getCardString()
        tvCard.text = s
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnAddCard.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}