package com.example.onlinestore.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryOrdersModel(
    val number: String,
    val status: String,
    val data: String,
    val price: String,
    val image: Int,
    val title: String
) : Parcelable