package com.example.onlinestore.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.navigationadvancedsample.setupWithNavController
import com.example.onlinestore.R
import com.example.onlinestore.utils.ext.showLightStatusBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomView()
        showLightStatusBar()
    }

    private fun setupBottomView() {
        val navView = findViewById<BottomNavigationView>(R.id.bottomNav)

        val navIds = listOf(
            R.navigation.main,
            R.navigation.cart,
            R.navigation.favorites,
            R.navigation.profile
        )

        navView.setupWithNavController(
            navGraphIds = navIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navView,
            intent = intent
        )
    }
}