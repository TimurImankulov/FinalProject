package com.example.onlinestore.ui.productsdetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.model.Images
import com.example.onlinestore.data.model.Specification
import com.example.onlinestore.databinding.FragmentRelatedProductDetailsBinding
import com.example.onlinestore.utils.ext.strikeThroughSpan
import com.example.onlinestore.utils.ext.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RelatedProductDetailsFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_related_product_details
    private val binding by viewBinding(FragmentRelatedProductDetailsBinding::bind)
    private val args: RelatedProductDetailsFragmentArgs by navArgs()
    private val vm by viewModel<RelatedProductVM>()

    private val slideAdapter by lazy {
        PhotoPagerAdapter() {
            navigateToPhoto(it)
        }
    }
    private val specAdapter by lazy { MultipleAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupListeners()
        setupView()
    }

    private fun setupView() {
        val item = args.details
        item?.images?.let { slideAdapter.update(it) }

        val specs = if (item?.specification?.size ?: 0 > 3) item?.specification?.subList(
            0,
            3
        ) else item?.specification
        specs?.let { specAdapter.update(it) }
        binding.tvProductName.text = item?.full_title
        binding.tvPrice.text = item?.priceNew
        binding.tvOldPrice.text = item?.old_price?.strikeThroughSpan()
        binding.tvDescription.text = item?.description
    }

    private fun setupListeners() {
        binding.tvSeeMoreDescription.setOnClickListener {
            navigateToDescription(args.details?.description)
        }

        binding.tvSeeMoreDetails.setOnClickListener {
            navigateToDetails(args.details?.specification)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnAddToCart.setOnClickListener {
            vm.addToCart(args.details)
        }
    }

    private fun setupViewPager() {
        binding.slideViewPager.adapter = slideAdapter
        binding.recyclerViewProductSpecification.adapter = specAdapter
    }

    private fun navigateToDescription(data: String?) {
        val destination =
            RelatedProductDetailsFragmentDirections.actionRelatedProductDetailsFragmentToDescriptionFragment(
                data
            )
        findNavController().navigate(destination)
    }

    private fun navigateToDetails(data: List<Specification>?) {
        val destination =
            RelatedProductDetailsFragmentDirections.actionRelatedProductDetailsFragmentToSpecificationFragment(
                data?.toTypedArray()
            )
        findNavController().navigate(destination)
    }

    private fun navigateToPhoto(data: Images) {
        val destination =
            RelatedProductDetailsFragmentDirections.actionRelatedProductDetailsFragmentToPhotoDetailsFragment(
                data
            )
        findNavController().navigate(destination)
    }
}