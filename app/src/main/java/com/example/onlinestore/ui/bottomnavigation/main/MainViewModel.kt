package com.example.onlinestore.ui.bottomnavigation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinestore.R
import com.example.onlinestore.data.model.CategoryModel

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<CategoryModel>>()
    val dataSales = MutableLiveData<List<CategoryModel>>()
    val dataBest = MutableLiveData<List<CategoryModel>>()

    init {
        generateMainData()
        generateData()
        generateBestData()
    }
    private fun generateBestData(){
        val list2 = arrayListOf<CategoryModel>()

        list2.add(
            CategoryModel(
                image = R.drawable.samsung, title = "Samsung Galaxy s20 Ultra"
            )
        )
        list2.add(
            CategoryModel(
                image = R.drawable.xiaomi, title = "Xiaomi Mi 10 Pro"
            )
        )
        list2.add(
            CategoryModel(
                image = R.drawable.samsung_note, title = "Samsung Note 20 Ultra"
            )
        )
        list2.add(
            CategoryModel(
                image = R.drawable.motorola, title = "Motorola One Edge"
            )
        )
        dataBest.postValue(list2)
    }

    private fun generateData(){
        val list1 = arrayListOf<CategoryModel>()

        list1.add(
            CategoryModel(
                image = R.drawable.iphone, title = "Iphone 12"
            )
        )
        list1.add(
            CategoryModel(
                image = R.drawable.iphone, title = "Iphone 12"
            )
        )
        list1.add(
            CategoryModel(
                image = R.drawable.iphone, title = "Iphone 12"
            )
        )

        dataSales.postValue(list1)

    }

    private fun generateMainData() {
        val list = arrayListOf<CategoryModel>()


        list.add(
            CategoryModel(
                image = R.drawable.ic_computer, title = "Computer"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.ic_phone, title = "Phone"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.ic_books, title = "Books"
            )
        )
        list.add(
            CategoryModel(
                image = R.drawable.ic_health, title = "Health"
            )
        )

        data.postValue(list)
    }
}