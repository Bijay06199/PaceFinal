package com.example.projectsetup.data.prefs

import android.content.SharedPreferences

interface PreferenceManager {
    fun setToken(token: String)
    fun getToken(): String
    fun setIsLoggedIn(isLoggedIn: Boolean)
    fun getIsLoggedIn():Boolean
}
