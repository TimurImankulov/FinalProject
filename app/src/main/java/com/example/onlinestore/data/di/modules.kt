package com.example.onlinestore.data.di

import com.example.onlinestore.data.interactor.FirebaseApi
import com.example.onlinestore.data.interactor.FirebaseApiImpl
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.repository.FirebaseRepository
import com.example.onlinestore.data.repository.FirebaseRepositoryImpl
import com.example.onlinestore.ui.bottomnavigation.cart.CartViewModel
import com.example.onlinestore.ui.bottomnavigation.catalog.CatalogViewModel
import com.example.onlinestore.ui.bottomnavigation.main.MainViewModel
import com.example.onlinestore.ui.bottomnavigation.profile.ProfileViewModel
import com.example.onlinestore.ui.productsdetails.ProductDetailsVM
import com.example.onlinestore.ui.relatedproductdetails.RelatedProductVM
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { CatalogViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { ProductDetailsVM(db = get()) }
    viewModel { CartViewModel(db = get()) }
    viewModel { RelatedProductVM(db = get()) }
    viewModel { ProfileViewModel(db = get()) }
}

val dbModule: Module = module {
    single<OnlineStoreDataBase> { OnlineStoreDataBase.getInstanceDB(androidApplication()) }
}

val repositoryModule: Module = module {
    single<FirebaseRepository> { FirebaseRepositoryImpl(get()) }
}

val apiModule: Module = module {
    single<FirebaseApi> { FirebaseApiImpl() }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule, dbModule)
