package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyAddressViewModel:BaseViewModel() {


    val btnClickedEvent=SingleLiveEvent<Unit>()
    val backClickedEvent=SingleLiveEvent<Unit>()


    fun onBtnClicked(){

        btnClickedEvent.call()
    }

    fun onBack(){

      backClickedEvent.call()

    }
}