package com.example.projectsetup.di

import com.example.projectsetup.data.api.ApiServices
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRepository
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRepositoryImpl
import com.example.projectsetup.ui.login.LoginRepository
import com.example.projectsetup.ui.login.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single {

        provideForgotPasswordRepository(get())
    }
    single {
        provideLoginRepository(get(), get())
    }
}

fun provideForgotPasswordRepository(apiServices: ApiServices): ForgotPasswordRepository {

    return ForgotPasswordRepositoryImpl(apiServices)


}

fun provideLoginRepository(
    apiServices: ApiServices,
    preferenceManager: PreferenceManager
): LoginRepository {
    return LoginRepositoryImpl(apiServices, preferenceManager)
}