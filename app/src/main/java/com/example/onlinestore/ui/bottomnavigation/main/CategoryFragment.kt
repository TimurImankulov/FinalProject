package com.example.onlinestore.ui.bottomnavigation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.test.ProductListModel
import com.example.onlinestore.databinding.FragmentCategoryBinding
import com.example.onlinestore.utils.ext.viewBinding

class CategoryFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_category
    private val binding by viewBinding(FragmentCategoryBinding::bind)
    private val args: CategoryFragmentArgs by navArgs()

    private val productCategoryAdapter by lazy {
        ProductCategoryAdapter() {
            navigateToProductDetails(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListeners()
        setupViews()
    }

    private fun setupViews() {
        val item = args.data
        binding.tvTitle.text = item
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewProductCategory.adapter = productCategoryAdapter
        productCategoryAdapter.submitList(args.details?.toList())
        binding.recyclerViewProductCategory.layoutManager = GridLayoutManager(context, 2)
    }

    private fun navigateToProductDetails(data: ProductListModel) {
        val destination =
            CategoryFragmentDirections.actionCategoryFragmentToProductDetailsFragment(data)
        findNavController().navigate(destination)
    }

    private fun generateBestData(): ArrayList<CategoryModel> {
        val list = arrayListOf<CategoryModel>()

        list.add(
            CategoryModel(
                image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.xiaomi, title = "Xiaomi Mi 10 Pro"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.samsung_note, title = "Samsung Note 20 Ultra"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.motorola, title = "Motorola One Edge"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.samsung_note, title = "Samsung Note 20 Ultra"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.motorola, title = "Motorola One Edge"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.samsung_note, title = "Samsung Note 20 Ultra"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.motorola, title = "Motorola One Edge"
            )
        )
        return list
    }
}


