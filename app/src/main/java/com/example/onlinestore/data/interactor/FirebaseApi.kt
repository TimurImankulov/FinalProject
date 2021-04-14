package com.example.onlinestore.data.interactor

import androidx.lifecycle.MutableLiveData
import com.example.onlinestore.BuildConfig.baseUrl
import com.example.onlinestore.data.model.MainModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


interface FirebaseApi {
    fun loadData(): MutableLiveData<MainModel>
}

class FirebaseApiImpl : FirebaseApi {

    override fun loadData(): MutableLiveData<MainModel> {
        val datafirebase = MutableLiveData<MainModel>()
        val database = Firebase.database
        val ref = database.getReferenceFromUrl(baseUrl)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(MainModel::class.java)
                datafirebase.postValue(data)
            }

            override fun onCancelled(error: DatabaseError) {
                datafirebase.postValue(null)
            }
        })

        return datafirebase
    }
}
