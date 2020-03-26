package com.example.projectsetup.ui.navigation.fragment.account.registerproperty

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyRoomViewModel:BaseViewModel() {

    val btnAgentClick=SingleLiveEvent<Unit>()
    val btnRegisterClick=SingleLiveEvent<Unit>()
    val onBackClick=SingleLiveEvent<Unit>()

    fun onClickAgent(){
        btnAgentClick.call()
    }

    fun onClickRegister(){

        btnRegisterClick.call()
    }

    fun onBack(){
        onBackClick.call()

    }
}