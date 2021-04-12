package com.example.onlinestore.utils.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

    fun AppCompatActivity.addFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
