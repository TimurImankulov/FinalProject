package com.example.onlinestore.ui.registration

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.local.PreferenceHelper
import com.example.onlinestore.databinding.FragmentLoginBinding
import com.example.onlinestore.databinding.FragmentRegistrationBinding
import com.example.onlinestore.ui.main.MainActivity
import com.example.onlinestore.utils.ext.viewBinding
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_registration
    private val binding by viewBinding(FragmentRegistrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            requireActivity().finish()
            saveData()
        }
    }

    private fun saveData(){
        val name = binding.etName.text.toString()
        PreferenceHelper.setName(name)

        val phoneNumber = binding.etPhoneNumber.text.toString()
        PreferenceHelper.setPhoneNumber(phoneNumber)

        val email = binding.etEmail.text.toString()
        PreferenceHelper.setEmail(email)

        val password = binding.etPassword.text.toString()
        PreferenceHelper.setPassword(password)

        val repeatPassword = binding.etRepeatPassword.text.toString()
        PreferenceHelper.setRepeatPassword(repeatPassword)
    }
}