package com.example.projectsetup.ui.forgotpassword.code

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class CodeViewModel:BaseViewModel() {

    val enter4digit:String=""
    val codesent:String=""
    val next:String=""

    val btnNextClickEvent=SingleLiveEvent<Unit>()
    val ivBackClickEvent=SingleLiveEvent<Unit>()

    fun onButtonClicked(){
        btnNextClickEvent.call()

    }

    fun onBackClick(){
        ivBackClickEvent.call()

    }



}