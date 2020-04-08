package com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class AccountVerificationViewModel:BaseViewModel() {

    val backClickedEvent=SingleLiveEvent<Unit>()
    val idClickedEvent=SingleLiveEvent<Unit>()
    val mobileClickedEvent=SingleLiveEvent<Unit>()
    val emailClickedEvent=SingleLiveEvent<Unit>()

    fun back(){
        backClickedEvent.call()
    }

    fun idClicked(){
        idClickedEvent.call()
    }

    fun mobileClicked(){
        mobileClickedEvent.call()
    }

    fun emailClicked(){
        emailClickedEvent.call()
    }
}