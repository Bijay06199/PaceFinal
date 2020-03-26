package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyFacilitiesViewModel:BaseViewModel() {

     val btnClickEvent=SingleLiveEvent<Unit>()
    val ivBackClickEvent=SingleLiveEvent<Unit>()

    fun onBtnClicked(){

        btnClickEvent.call()
    }

    fun onBack(){
        ivBackClickEvent.call()
    }
}