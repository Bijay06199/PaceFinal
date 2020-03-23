package com.example.projectsetup.base

import android.app.Application
import com.example.projectsetup.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class PaceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PaceApp)

            androidFileProperties()
            modules(
                listOf(
                    appModule, apiModule,
                    persistenceDataModule, viewModelModule, repositoryModule
                )
            )
        }


    }

}