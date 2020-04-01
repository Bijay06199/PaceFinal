package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyChooseViewModel:BaseViewModel() {

    val ivBackClickedEvent=SingleLiveEvent<Unit>()
    val btnNextCLickedEvent=SingleLiveEvent<Unit>()


    fun next(){
        btnNextCLickedEvent.call()
    }
    fun back(){
        ivBackClickedEvent.call()
    }


}