package com.example.projectsetup.ui.forgotpassword.resetsuccessful

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class ResetPasswordSuccessfullModel:BaseViewModel() {

    val passwordreset:String=""
    val successful:String=""
    val sent:String=""
    val login:String=""

    val btnNextClicked=SingleLiveEvent<Unit>()

    fun onNext(){
        btnNextClicked.call()
    }
}