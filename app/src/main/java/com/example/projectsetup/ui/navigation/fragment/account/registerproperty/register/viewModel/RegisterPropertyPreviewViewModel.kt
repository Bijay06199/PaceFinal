package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyPreviewViewModel:BaseViewModel() {

    val ivBackClickedEvent= SingleLiveEvent<Unit>()
    val btnRegisterClickedEvent= SingleLiveEvent<Unit>()



    fun onBack()
    {
        ivBackClickedEvent.call()
    }

    fun Register(){
        btnRegisterClickedEvent.call()

    }
}