package com.example.projectsetup.ui.forgotpassword.resetpassword

import android.content.Context
import android.content.Intent
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.ui.forgotpassword.code.CodeActivity
import com.example.projectsetup.utils.SingleLiveEvent

class ResetPasswordViewModel:BaseViewModel() {

    val btnNextClicked=SingleLiveEvent<Unit>()
    val ivBackClicked=SingleLiveEvent<Unit>()

    val resetpassword:String=""
    val enternewpassword:String=""
    val confirmpassword:String=""



    fun onBackClicked() {
        ivBackClicked.call()

    }

    fun onNextClicked(){
        btnNextClicked.call()
    }
}

