package com.example.onlinestore.ui.photodetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.databinding.FragmentPhotoDetailsBinding
import com.example.onlinestore.utils.ext.viewBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_photo_details.*

class PhotoDetailsFragment:BaseFragment() {
    override fun resID() = R.layout.fragment_photo_details
    private val args: PhotoDetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentPhotoDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListener()
    }

    private fun setupListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupViews() {
        args.details?.image?.let {
            Picasso.get()
                .load(it)
                .into(photo_view)
        }
    }
}