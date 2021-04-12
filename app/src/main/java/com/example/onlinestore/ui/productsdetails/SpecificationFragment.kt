package com.example.onlinestore.ui.productsdetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.SpecsModel
import com.example.onlinestore.databinding.FragmentSpecificationBinding
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

    private fun generateSpecData(): List<SpecsModel> {
        val list = arrayListOf<SpecsModel>()
        var newList = listOf<SpecsModel>()

        list.add(SpecsModel.generateMemory())
        list.add(SpecsModel.generateDisplay())
        list.add(SpecsModel.generateCamera())
        list.add(SpecsModel.generateOS())
        list.add(SpecsModel.generateBatteries())

        newList = if (list.size >= 5) {
            list.subList(0, 5)
        } else {
            list
        }

        return newList
    }
}