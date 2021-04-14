package com.example.onlinestore.ui.bottomnavigation.main

import androidx.lifecycle.ViewModel
import com.example.onlinestore.data.repository.FirebaseRepository

class MainViewModel(private val repository: FirebaseRepository) : ViewModel() {

    fun showData() = repository.loadData()
}