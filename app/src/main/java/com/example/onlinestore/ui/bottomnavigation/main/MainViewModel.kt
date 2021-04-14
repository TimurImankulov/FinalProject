package com.example.onlinestore.ui.bottomnavigation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinestore.data.model.CategoryModel
import com.example.onlinestore.data.test.MainModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainViewModel() : ViewModel() {

    val data = MutableLiveData<List<CategoryModel>>()
    val datafirebase = MutableLiveData<MainModel>()

    init {
        loadData()
    }


    fun loadData() {
        val database = Firebase.database
        val ref =
            database.getReferenceFromUrl("https://online-store-database-985ae-default-rtdb.firebaseio.com/")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(MainModel::class.java)
                datafirebase.postValue(data)
            }

            override fun onCancelled(error: DatabaseError) {
                datafirebase.postValue(null)
            }
        })
    }
}