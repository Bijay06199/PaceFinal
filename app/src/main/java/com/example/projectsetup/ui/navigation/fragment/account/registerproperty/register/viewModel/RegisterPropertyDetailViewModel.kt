package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyDetailViewModel:BaseViewModel() {

    val btnClickEvent=SingleLiveEvent<Unit>()

    fun onBtnClicked(){

        btnClickEvent.call()
    }
}