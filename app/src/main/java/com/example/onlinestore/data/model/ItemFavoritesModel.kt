package com.example.onlinestore.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class ItemFavoritesModel (
    @PrimaryKey
    @SerializedName("id") val id : Int? = null,
    @SerializedName("title") val title : String? = null,
    @SerializedName("full_title") val full_title : String? = null,
    @SerializedName("images") val images : List<Images>? = null,
    @SerializedName("image") val image : String? = null,
    @SerializedName("price") val price : String? = null,
    @SerializedName("old_price") val old_price : String? = null,
    @SerializedName("favorite") val favorite : Boolean? = null,
    @SerializedName("rank") val rank : Int? = null,
    @SerializedName("description") val description : String? = null,
    @SerializedName("specification") val specification : List<Specification>? = null,
    @SerializedName("related_product") val related_product : List<RelatedProductModel>? = null
): Parcelable