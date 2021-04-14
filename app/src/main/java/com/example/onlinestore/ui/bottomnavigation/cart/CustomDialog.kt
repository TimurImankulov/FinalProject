package com.example.onlinestore.ui.bottomnavigation.cart

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.onlinestore.R
import kotlinx.android.synthetic.main.custom_dialog.*

class CustomDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        setupListener()
    }

    private fun setupListener() {
        btn_Ok.setOnClickListener {
            dismiss()
        }
    }
}