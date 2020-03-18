package com.example.projectsetup.di

import com.example.projectsetup.data.api.ApiServices
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRepository
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRepositoryImpl
import org.koin.dsl.module

val repositoryModule= module {

    single {

        provideForgotPasswordRepository(get())
    }
}

fun provideForgotPasswordRepository(apiServices: ApiServices):ForgotPasswordRepository {

    return ForgotPasswordRepositoryImpl(apiServices)



}
