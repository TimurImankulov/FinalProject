package com.example.onlinestore.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    val image: Int,
    val title: String
) : Parcelable
