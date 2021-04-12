package com.example.onlinestore.ui.bottomnavigation.main

import androidx.lifecycle.MutableLiveData
import com.example.onlinestore.R
import com.example.onlinestore.data.common.FavoriteViewModel
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.test.MainModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainViewModel(db: OnlineStoreDataBase) : FavoriteViewModel(db) {

    val data = MutableLiveData<List<CategoryModel>>()
    val dataSales = MutableLiveData<List<CategoryModel>>()
    val dataBest = MutableLiveData<List<CategoryModel>>()
    val datafirebase = MutableLiveData<MainModel>()


    init {
        generateMainData()
        generateData()
        generateBestData()
        loadData()
    }


    fun loadData(){
        val database = Firebase.database
        val ref = database.getReferenceFromUrl("https://online-store-database-985ae-default-rtdb.firebaseio.com/")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(MainModel::class.java)
                datafirebase.postValue(data)
//                data?.category?.product_category?.get(0)?.items?.bestsales?.product_list?.let {
//                    db.getDao().insert(
//                        it
//                    )
//                }
            }

            override fun onCancelled(error: DatabaseError) {
                datafirebase.postValue(null)
            }
        })
    }

//    fun getAllFavourites(): LiveData<List<ProductListModel>> {
//        return db.getDao().getFavourite()
//    }




//    ref.addValueEventListener(object : ValueEventListener {
//        override fun onDataChange(snapshot: DataSnapshot) {
//            val list: ArrayList<NewsItem>? = arrayListOf()
//            for (postSnapshot in snapshot.children) {
//                val point = postSnapshot.getValue(NewsItem::class.java)
//                point?.let { list?.add(it) }
//            }
//            data.postValue(list)
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            data.postValue(null)
//        }
//    })
//
//    return data

    private fun generateBestData(){
        val list2 = arrayListOf<CategoryModel>()

        list2.add(
            CategoryModel(
                image = R.drawable.airpods, title = "Samsung Galaxy s20 Ultra"
            )
        )
        list2.add(
            CategoryModel(
                image = R.drawable.airpods_one, title = "Xiaomi Mi 10 Pro"
            )
        )
        list2.add(
            CategoryModel(
                image = R.drawable.airpods_two, title = "Samsung Note 20 Ultra"
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