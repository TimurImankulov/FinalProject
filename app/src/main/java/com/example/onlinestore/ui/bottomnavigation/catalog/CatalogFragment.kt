package com.example.onlinestore.ui.bottomnavigation.catalog

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.ProductListModel
import com.example.onlinestore.databinding.FragmentCatalogBinding
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_catalog
    private val vm by viewModel<CatalogViewModel>()
    private val binding by viewBinding(FragmentCatalogBinding::bind)
    private val adapter by lazy { ExpandableAdapter(){
        navigateToProductDetails(it)
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupExpListView()
        setupViewModel()
    }

    private fun setupViewModel() {
        vm.showData().observe(viewLifecycleOwner, {
           it.category?.catalog?.let { it1 -> adapter.update(it1) }
        })
    }

    private fun setupExpListView() {
        binding.listView.setAdapter(adapter)
    }

    private fun navigateToProductDetails(list: List<ProductListModel>?) {
        val destination = CatalogFragmentDirections.actionCatalogFragmentToCategoryFragment(list?.toTypedArray(), "Category")
        findNavController().navigate(destination)
    }
}