package com.example.projectsetup.data.prefs

import android.content.SharedPreferences

interface PreferenceManager {
    fun setToken(token: String)
    fun getToken(): String
    fun setIsLoggedIn(isLoggedIn: Boolean)
    fun getIsLoggedIn():Boolean
    fun setRegistrationType(registrationType: Int)
    fun getRegistrationType():Int
    fun setLanguageType(languageType:Int)
    fun getLanguageType():Int

}
