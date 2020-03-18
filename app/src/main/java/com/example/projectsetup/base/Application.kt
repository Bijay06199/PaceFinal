package com.example.projectsetup.base

import android.app.Application
import com.example.projectsetup.di.apiModule
import com.example.projectsetup.di.appModule
import com.example.projectsetup.di.repositoryModule
import com.example.projectsetup.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class PaceApp:Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PaceApp)

            androidFileProperties()
            modules(listOf(appModule, apiModule, viewModelModule, repositoryModule))
        }


    }

}