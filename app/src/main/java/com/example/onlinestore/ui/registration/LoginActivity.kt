package com.example.onlinestore.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.onlinestore.R

class LoginActivity : AppCompatActivity() {

    private var host : NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        host = Navigation.findNavController(this, R.id.container)

    }
}