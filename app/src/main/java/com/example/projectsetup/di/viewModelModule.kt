package com.example.projectsetup.di

import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRepository
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordViewModel
import com.example.projectsetup.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule:Module= module {

    viewModel { ForgotPasswordViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}