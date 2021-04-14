package com.example.onlinestore.data.local

import androidx.room.TypeConverter
import com.example.onlinestore.data.model.CartProductListModel
import com.example.onlinestore.data.model.Images
import com.example.onlinestore.data.model.RelatedProductModel
import com.example.onlinestore.data.model.Specification
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object TypeConverter {

    @JvmStatic
    @TypeConverter
    fun imagesToString(model: List<Images>?): String? {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun imagesToObject(text: String?): List<Images>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<Images>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun specificationToString(model: List<Specification>?): String? {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun specificationToObject(text: String?): List<Specification>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<Specification>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun relatedProductToString(model: List<RelatedProductModel>?): String? {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun relatedProductToObject(text: String?): List<RelatedProductModel>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<RelatedProductModel>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun cartProductToString(model: List<CartProductListModel>?): String? {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun cartProductToObject(text: String?): List<CartProductListModel>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<CartProductListModel>>() {}.type
        return Gson().fromJson(text, typeToken)
    }
}