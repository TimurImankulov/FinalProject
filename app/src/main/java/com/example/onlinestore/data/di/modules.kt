package com.example.onlinestore.data.di

import com.example.onlinestore.ui.bottomnavigation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { MainViewModel() }
}

val repositoryModule: Module = module {
}

val apiModule: Module = module {

}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)