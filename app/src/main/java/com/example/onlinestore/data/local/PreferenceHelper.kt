package com.example.onlinestore.data.local

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private const val PREFERENCE_NAME = "FitnessPreference"
    private const val NAME = "NAME"
    private const val PHONE_NUMBER = "PHONE_NUMBER"
    private const val E_MAIL = "E_MAIL"
    private const val PASSWORD = "PASSWORD"
    private const val REPEAT_PASSWORD = "PASSWORD"

    private var preference: SharedPreferences? = null

    fun init(context: Context) {
        preference = context.getSharedPreferences(
            PREFERENCE_NAME, Context.MODE_PRIVATE
        )
    }

    fun setName(data: String) {
        preference?.edit()?.putString(
            NAME, data
        )?.apply()
    }

    fun getName(): String? {
        return preference?.getString(
            NAME, null
        )
    }

    fun setPhoneNumber(data: String) {
        preference?.edit()?.putString(
            PHONE_NUMBER, data
        )?.apply()
    }

    fun getPhoneNumber(): String? {
        return preference?.getString(
            PHONE_NUMBER, null
        )
    }

    fun setEmail(data: String) {
        preference?.edit()?.putString(
            E_MAIL, data
        )?.apply()
    }

    fun getEmail(): String? {
        return preference?.getString(
            E_MAIL, null
        )
    }

    fun setPassword(data: String) {
        preference?.edit()?.putString(
            PASSWORD, data
        )?.apply()
    }

    fun getPassword(): String? {
        return preference?.getString(
            PASSWORD, null
        )
    }

    fun setRepeatPassword(data: String) {
        preference?.edit()?.putString(
            REPEAT_PASSWORD, data
        )?.apply()
    }

    fun getRepeatPassword(): String? {
        return preference?.getString(
            REPEAT_PASSWORD, null
        )
    }
}