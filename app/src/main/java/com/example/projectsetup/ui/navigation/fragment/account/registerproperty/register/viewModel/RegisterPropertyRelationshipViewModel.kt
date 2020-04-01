package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyRelationshipViewModel:BaseViewModel() {

    val btnNextClickedEvent=SingleLiveEvent<Unit>()
    val ivBackEvent=SingleLiveEvent<Unit>()


    fun onBtnClicked(){
        btnNextClickedEvent.call()
    }

    fun onBack(){
        ivBackEvent.call()
    }

}