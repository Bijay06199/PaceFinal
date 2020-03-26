package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyWantViewModel:BaseViewModel() {

    val btnNextClick=SingleLiveEvent<Unit>()
    val ivBack=SingleLiveEvent<Unit>()

    fun onBtnClicked(){

        btnNextClick.call()
    }

    fun onBackClick(){
        ivBack.call()
    }
}