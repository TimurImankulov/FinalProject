package com.example.onlinestore.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.onlinestore.R
import com.example.onlinestore.data.common.BaseFragment
import com.example.onlinestore.data.local.PreferenceHelper
import com.example.onlinestore.databinding.FragmentLoginBinding
import com.example.onlinestore.ui.main.MainActivity
import com.example.onlinestore.utils.ext.viewBinding

class LoginFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_login
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegistration.setOnClickListener {
            navigateToRegistration()
        }

        binding.btnSkipLogin.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            requireActivity().finish()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login(){

        val login = binding.etLogin.text.toString()
        val password = binding.etPassword.text.toString()

        val loginFromPref = PreferenceHelper.getName().toString()
        val passwordFromPref = PreferenceHelper.getPassword().toString()

        if (loginFromPref == login && passwordFromPref == password){
            startActivity(Intent(activity, MainActivity::class.java))
            requireActivity().finish()
        } else {
            Toast.makeText(activity,"Логин или пароль не верны", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToRegistration() {
        val destination = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        findNavController().navigate(destination)
    }
}