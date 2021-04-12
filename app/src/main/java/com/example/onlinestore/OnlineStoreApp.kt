package com.example.onlinestore

import android.app.Application
import com.example.onlinestore.data.di.appModules
import com.example.onlinestore.data.local.PreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OnlineStoreApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(applicationContext)
        startKoin {
            androidContext(this@OnlineStoreApp)
            modules(appModules)
        }
    }
}
