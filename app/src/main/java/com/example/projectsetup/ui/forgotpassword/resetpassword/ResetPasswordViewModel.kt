package com.example.projectsetup.ui.forgotpassword.resetpassword

import android.content.Context
import android.content.Intent
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.ui.forgotpassword.code.CodeActivity

class ResetPasswordViewModel:BaseViewModel() {

    val resetpassword:String=""
    val enternewpassword:String=""
    val confirmpassword:String=""



}

fun onBack(context: Context) {
    val intent = Intent(context, CodeActivity::class.java)
    context.startActivity(intent)
}