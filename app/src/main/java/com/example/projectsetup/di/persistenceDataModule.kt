package com.example.projectsetup.di

import android.content.Context
import android.content.SharedPreferences
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.data.prefs.PreferenceManagerImpl
import org.koin.dsl.module

val persistenceDataModule = module {
    single {
        provideSharedPreference(get(), "PaceApp_prefs")
    }
    single {
        providePreferenceManager(get())
    }
}

fun provideSharedPreference(context: Context, preferenceName: String): SharedPreferences {
    return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}

fun providePreferenceManager(preferences: SharedPreferences): PreferenceManager =
    PreferenceManagerImpl(preferences)