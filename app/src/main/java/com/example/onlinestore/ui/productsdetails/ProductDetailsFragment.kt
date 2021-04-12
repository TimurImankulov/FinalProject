package com.example.onlinestore.ui.productsdetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.model.SpecsModel
import com.example.onlinestore.data.test.Images
import com.example.onlinestore.data.test.RelatedProductModel
import com.example.onlinestore.data.test.Specification
import com.example.onlinestore.databinding.FragmentProductDetailsBinding
import com.example.onlinestore.utils.decorators.ItemOffsetDecoration
import com.example.onlinestore.utils.ext.strikeThroughSpan
import com.example.onlinestore.utils.ext.viewBinding

class ProductDetailsFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_product_details
    private val binding by viewBinding(FragmentProductDetailsBinding::bind)
    private val args: ProductDetailsFragmentArgs by navArgs()

    private val slideAdapter by lazy {
        PhotoPagerAdapter() {
            navigateToPhoto(it)
        }
    }
    private val specAdapter by lazy { MultipleAdapter() }
    private val relatedProductAdapter by lazy {
        RelatedProductAdapter() {
            navigateToRelatedProductDetails(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListeners()
        setupView()
    }

    private fun setupView() {
        val item = args.details
        item?.images?.let { slideAdapter.update(it) }
        val specs = if(item?.specification?.size ?:0 > 3 )  item?.specification?.subList(0,3) else item?.specification
            specs?.let { specAdapter.update(it) }
        binding.tvProductName.text = item?.full_title
        binding.tvPrice.text = item?.price
        binding.tvOldPrice.text = item?.old_price?.strikeThroughSpan()
        binding.tvDescription.text = item?.description
    }

    private fun setupListeners() {
        binding.tvSeeMoreDescription.setOnClickListener {
            args.details?.description?.let { navigateToDescription(it) }
        }

        binding.tvSeeMoreDetails.setOnClickListener {
            navigateToDetails( args.details?.specification)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerView() {
        binding.slideViewPager.adapter = slideAdapter

        binding.recyclerViewProductSpecification.adapter = specAdapter


        binding.recyclerViewRelatedProduct.adapter = relatedProductAdapter
        relatedProductAdapter.submitList(args.details?.related_product)
        binding.recyclerViewRelatedProduct.addItemDecoration(
            ItemOffsetDecoration(
                firstItemLeftMargin = 20f,
                lastItemRightMargin = 20f,
                itemBottomMargin = 54f,
                isNeedBottomMargin = true
            )
        )
    }

    private fun navigateToDescription(data: String) {
        val destination =
            ProductDetailsFragmentDirections.actionProductDetailsFragmentToDescriptionFragment(data)
        findNavController().navigate(destination)
    }

    private fun navigateToDetails(data: List<Specification>?) {
        val destination = ProductDetailsFragmentDirections.actionProductDetailsFragmentToSpecificationFragment(data?.toTypedArray())
        findNavController().navigate(destination)
    }

    private fun navigateToRelatedProductDetails(data: RelatedProductModel) {
        val destination =
            ProductDetailsFragmentDirections.actionProductDetailsFragmentToRelatedProductDetailsFragment(data)
        findNavController().navigate(destination)
    }

    private fun navigateToPhoto(data: Images) {
        val destination =
            ProductDetailsFragmentDirections.actionProductDetailsFragmentToPhotoDetailsFragment(data)
        findNavController().navigate(destination)
    }

//    private fun getDataForPhotoPager(): ArrayList<Int> {
//        val list = arrayListOf<Int>()
//        list.add(R.drawable.xiaomi)
//        list.add(R.drawable.samsung_note)
//        list.add(R.drawable.motorola)
//
//        return list
//    }

    private fun generateSpecData(): List<SpecsModel> {
        val list = arrayListOf<SpecsModel>()
        var newList = listOf<SpecsModel>()

        list.add(SpecsModel.generateMemory())
        list.add(SpecsModel.generateDisplay())
        list.add(SpecsModel.generateCamera())
        list.add(SpecsModel.generateOS())
        list.add(SpecsModel.generateBatteries())

        newList = if (list.size >= 3) {
            list.subList(0, 3)
        } else {
            list
        }

        return newList
    }

    private fun generateData(): List<CategoryModel> {
        val list = arrayListOf<CategoryModel>()

        list.add(
            CategoryModel(
                image = R.drawable.iphone12_pacific_blue, title = "Samsung Galaxy s20 Ultra"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.iphone12_pacific_blue_one, title = "Xiaomi Mi 10 Pro"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.iphone12_pacific_blue_two, title = "Samsung Note 20 Ultra"
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