package com.example.onlinestore.data.test

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


@Entity
@Parcelize
data class CartProductListModel(
    @PrimaryKey
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("full_title") val full_title: String? = null,
    @SerializedName("images") val images: List<Images>? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("old_price") val old_price: String? = null,
    @SerializedName("favorite") var favorite: Boolean? = null,
    @SerializedName("rank") val rank: Int? = null,
    var count: Int = 0,
    @SerializedName("description") val description: String? = null,
    @SerializedName("specification") val specification: List<Specification>? = null,
    @SerializedName("related_product") val related_product: List<RelatedProductModel>? = null
) : Parcelable