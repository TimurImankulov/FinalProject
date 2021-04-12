package com.example.onlinestore.ui.bottomnavigation.catalog

import androidx.lifecycle.ViewModel
import com.example.onlinestore.data.repository.FirebaseRepository


class CatalogViewModel(private val repository: FirebaseRepository) : ViewModel() {

    fun showData() = repository.loadData()
}