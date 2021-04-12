package com.example.onlinestore.ui.bottomnavigation.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.test.MainModel
import com.example.onlinestore.data.test.ProductCategoryModel
import com.example.onlinestore.data.test.ProductListModel
import com.example.onlinestore.databinding.FragmentMainBinding
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : BaseFragment() {

    override fun resID() = R.layout.fragment_main
    private val vm by sharedViewModel<MainViewModel>()
    private val binding by viewBinding(FragmentMainBinding::bind)
    private var categoryPosition = 0

    private val categoryAdapter by lazy {
        CategoryAdapter() { position, item ->
            changeCategory(position, item)
        }
    }
    private val productCategoryAdapter by lazy {
        ProductCategoryAdapter(vm) {
              navigateToProductDetails(it)
        }
    }

    private fun changeCategory(position: Int, item: ProductCategoryModel) {
        categoryPosition = position
        productCategoryAdapter.submitList(item.items?.bestsales?.product_list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
        setupListeners()
    }

    private fun setupListeners() {
        binding.tvSeeMoreBestSales.setOnClickListener {
            vm.datafirebase.observe(viewLifecycleOwner, Observer {
                navigateToBestSalesCategory(it)
            })
        }

        binding.tvSeeMoreHotSales.setOnClickListener {
            vm.datafirebase.observe(viewLifecycleOwner, Observer {
                navigateToHotSalesCategory(it)
            })
        }
    }

    private fun setupViewModel() {
        vm.datafirebase.observe(viewLifecycleOwner, Observer {
            categoryAdapter.submitList(it.category?.product_category)
        })

        vm.datafirebase.observe(viewLifecycleOwner, Observer {
            productCategoryAdapter.submitList(it?.category?.product_category?.get(categoryPosition)?.items?.bestsales?.product_list)
        })

        vm.datafirebase.observe(viewLifecycleOwner, Observer {
            binding.tvTitle.text = it?.category?.product_category?.get(categoryPosition)?.bestsales_title
            binding.tvDescriptions.text = it?.category?.product_category?.get(categoryPosition)?.bestsales_description
        })

    }

    private fun setupRecyclerView() {
        binding.recyclerViewCategory.adapter = categoryAdapter
        binding.recyclerViewBestSales.adapter = productCategoryAdapter
        binding.recyclerViewBestSales.layoutManager = GridLayoutManager(context, 2)

        binding.recyclerViewCategory.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 12f,
                itemRightMargin = 12f,
                firstItemLeftMargin = 28f,
                lastItemRightMargin = 28f
            )
        )

    }

    private fun navigateToBestSalesCategory(item: MainModel) {
        val data =
            item.category?.product_category?.get(categoryPosition)?.items?.bestsales?.product_list
        val destination =
            MainFragmentDirections.actionMainFragmentToCategoryFragment(data?.toTypedArray(), "BestSales")
        findNavController().navigate(destination)
    }

    private fun navigateToHotSalesCategory(item: MainModel) {
        val data =
            item.category?.product_category?.get(categoryPosition)?.items?.hotsales?.product_list
        val destination =
            MainFragmentDirections.actionMainFragmentToCategoryFragment(data?.toTypedArray(),"HotSales")
        findNavController().navigate(destination)
    }

    private fun navigateToProductDetails(data: ProductListModel) {
        val destination = MainFragmentDirections.actionMainFragmentToProductDetailsFragment(data)
        findNavController().navigate(destination)
    }
}