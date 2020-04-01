package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyMapViewModel:BaseViewModel() {


    val btnClickEvent= SingleLiveEvent<Unit>()
    val ivBackClickEvent=SingleLiveEvent<Unit>()


    fun btnClicked(){

        btnClickEvent.call()
    }

    fun back(){
        ivBackClickEvent.call()
    }
}