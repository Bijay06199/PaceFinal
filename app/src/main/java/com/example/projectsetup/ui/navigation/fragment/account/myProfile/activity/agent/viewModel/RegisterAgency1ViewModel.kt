package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterAgency1ViewModel:BaseViewModel() {

    val nextClickedEvent=SingleLiveEvent<Unit>()
    val backClickedEvent=SingleLiveEvent<Unit>()

    fun next(){
        nextClickedEvent.call()
    }

    fun back(){
        backClickedEvent.call()
    }


}