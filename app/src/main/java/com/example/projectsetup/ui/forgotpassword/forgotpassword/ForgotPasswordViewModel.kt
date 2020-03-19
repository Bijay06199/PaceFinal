package com.example.projectsetup.ui.forgotpassword.forgotpassword

import androidx.lifecycle.viewModelScope
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(val forgotpasswordRepo:ForgotPasswordRepository) : BaseViewModel() {

    val nextClickEvent = SingleLiveEvent<Unit>()

    val forgotpassword: String = ""
    val entercode: String = ""
    val verification: String = ""
    val enteryouremail: String = ""
    val next: String = ""


    fun onNextClicked(){
        nextClickEvent.call()


    }


    fun forgotPassword(email:String){



      //  viewModelScope.launch {val response= forgotpasswordRepo.forgotPassword(email) }
    }
}

