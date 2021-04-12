package com.example.onlinestore.ui.bottomnavigation.catalog

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.CatalogModel
import com.example.onlinestore.data.model.SecondModel
import com.example.onlinestore.data.test.ProductListModel
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
        val destination = CatalogFragmentDirections.actionCatalogFragmentToCategoryFragment(list?.toTypedArray(), "Apple")
        findNavController().navigate(destination)
    }

    private fun generateMainData(): ArrayList<CatalogModel> {
        val list = arrayListOf<CatalogModel>()

        list.add(
            CatalogModel(
                title = "TV", subList = generateTVData()
            )
        )
        list.add(
            CatalogModel(
                title = "Phones", subList = generatePhoneData()
            )
        )
        list.add(
            CatalogModel(
                title = "Photo and Video", subList = generatePhotoVideoData()
            )
        )
        list.add(
            CatalogModel(
                title = "Computers", subList = generateComputersData()
            )
        )

        return list
        }

    private fun generateTVData(): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()

            list.add(SecondModel(title = "TV"))
            list.add(SecondModel(title = "Digital tv"))
            list.add(SecondModel(title = "Projectors"))
            list.add(SecondModel(title = "Accessories"))

        return list
    }

    private fun generatePhoneData(): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()

        list.add(SecondModel(title = "Phones"))
        list.add(SecondModel(title = "Apple"))
        list.add(SecondModel(title = "Samsung"))
        list.add(SecondModel(title = "Xiaomi"))
        list.add(SecondModel(title = "Accessories"))

        return list
    }

    private fun generatePhotoVideoData(): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()

        list.add(SecondModel(title = "Сamera"))
        list.add(SecondModel(title = "Video camera"))
        list.add(SecondModel(title = "Accessories"))

        return list
    }

    private fun generateComputersData(): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()

        list.add(SecondModel(title = "Notebook"))
        list.add(SecondModel(title = "Monoblock"))
        list.add(SecondModel(title = "Routers"))
        list.add(SecondModel(title = "Accessories"))

        return list
    }
}