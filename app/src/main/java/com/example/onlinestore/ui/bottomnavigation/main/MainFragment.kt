package com.example.onlinestore.ui.bottomnavigation.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment: BaseFragment() {

    override fun resID() = R.layout.fragment_main
    private val vm by sharedViewModel<MainViewModel>()
    private val categoryAdapter by lazy { CategoryAdapter() }
    private val hotSalesAdapter by lazy { HotSalesAdapter() }
    private val bestSellerAdapter by lazy { BestSellerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        vm.data.observe(viewLifecycleOwner, Observer {
            categoryAdapter.submitList(it)
        })

        vm.dataSales.observe(viewLifecycleOwner, Observer {
            hotSalesAdapter.submitList(it)
        })

        vm.dataBest.observe(viewLifecycleOwner, Observer {
            bestSellerAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        recyclerViewCategory.adapter = categoryAdapter
        recyclerViewHotSales.adapter = hotSalesAdapter
        recyclerViewBestSales.adapter = bestSellerAdapter
        recyclerViewBestSales.layoutManager = GridLayoutManager(context, 2)

        recyclerViewCategory.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 12f,
                itemRightMargin = 12f,
                firstItemLeftMargin = 28f,
                lastItemRightMargin = 28f
            )
        )
    }
}