package com.example.onlinestore.ui.bottomnavigation.favorites

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentFavoritesBinding
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment:BaseFragment() {

    override fun resID() = R.layout.fragment_favorites
    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private val vm by viewModel<FavoritesViewModel>()
    private val favoriteAdapter by lazy { FavoriteAdapter(){
        navigateToProductDetails()
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        vm.getAllFavourites().observe(viewLifecycleOwner, Observer {
            favoriteAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerViewFavoriteProduct.adapter = favoriteAdapter


        binding.recyclerViewFavoriteProduct.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 16f,
                itemRightMargin = 16f,
                itemBottomMargin = 8f
            )
        )
    }

    private fun navigateToProductDetails() {
        val destination = FavoritesFragmentDirections.actionFavoritesFragmentToProductDetailsFragment()
        findNavController().navigate(destination)
    }
}