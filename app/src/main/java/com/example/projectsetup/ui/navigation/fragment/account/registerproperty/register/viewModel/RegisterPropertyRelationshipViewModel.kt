package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyRelationshipViewModel:BaseViewModel() {

    val btnNextClicked=SingleLiveEvent<Unit>()
    val ivBack=SingleLiveEvent<Unit>()


    fun onBtnClicked(){
        btnNextClicked.call()
    }

    fun onBack(){
        ivBack.call()
    }

}