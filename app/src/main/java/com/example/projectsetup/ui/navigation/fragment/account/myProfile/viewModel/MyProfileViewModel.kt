package com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class MyProfileViewModel:BaseViewModel(){

    val verifyClickedEvent=SingleLiveEvent<Unit>()
    val backClickedEvent=SingleLiveEvent<Unit>()
    val btnAgentClicked=SingleLiveEvent<Unit>()
    val btnAmbassadorClicked=SingleLiveEvent<Unit>()
    val editClicked=SingleLiveEvent<Unit>()


    fun verify(){
        verifyClickedEvent.call()
    }

    fun back(){
        backClickedEvent.call()
    }

    fun btnAgent(){
        btnAgentClicked.call()
    }

    fun btnAmbassador(){
        btnAmbassadorClicked.call()
    }

    fun edit(){
        editClicked.call()
    }
}