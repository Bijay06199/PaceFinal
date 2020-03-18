package com.example.projectsetup.ui.forgotpassword.forgotpassword

import com.example.projectsetup.data.api.ApiServices

interface ForgotPasswordRepository{

    suspend  fun forgotPassword(email:String)
}

class ForgotPasswordRepositoryImpl(private val apiServices: ApiServices):ForgotPasswordRepository{

    override suspend fun forgotPassword(email: String) {

    }

}