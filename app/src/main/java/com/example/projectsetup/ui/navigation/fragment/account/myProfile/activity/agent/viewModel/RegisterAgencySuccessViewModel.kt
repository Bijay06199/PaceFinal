package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterAgencySuccessViewModel:BaseViewModel() {
    val backClickedEvent=SingleLiveEvent<Unit>()

    fun back(){
        backClickedEvent.call()
    }

}