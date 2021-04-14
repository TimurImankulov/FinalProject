package com.example.onlinestore.ui.specification

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentSpecificationBinding
import com.example.onlinestore.ui.productsdetails.MultipleAdapter
import com.example.onlinestore.utils.ext.viewBinding

class SpecificationFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_specification
    private val binding by viewBinding(FragmentSpecificationBinding::bind)
    private val specAdapter by lazy { MultipleAdapter() }
    private val args: SpecificationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewProductSpecification.adapter = specAdapter
        args.details?.let { specAdapter.update(it?.toList()) }
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}