package com.example.onlinestore.ui.bottomnavigation.profile

import androidx.lifecycle.ViewModel
import com.example.onlinestore.data.local.OnlineStoreDataBase

class ProfileViewModel(private val db: OnlineStoreDataBase):ViewModel() {

    fun getData() = db.getOrder().getAllObservable()
}