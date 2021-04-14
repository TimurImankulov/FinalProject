package com.example.onlinestore.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.onlinestore.data.interactor.FirebaseApi
import com.example.onlinestore.data.model.MainModel

interface FirebaseRepository {
    fun loadData(): MutableLiveData<MainModel>
}

class FirebaseRepositoryImpl(private val network: FirebaseApi) : FirebaseRepository {

    override fun loadData(): MutableLiveData<MainModel> {
        val data = network.loadData()

        return data
    }
}