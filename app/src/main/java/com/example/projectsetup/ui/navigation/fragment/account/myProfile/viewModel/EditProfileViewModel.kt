package com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class EditProfileViewModel:BaseViewModel() {

    val backClickedEvent=SingleLiveEvent<Unit>()

    fun back(){
        backClickedEvent.call()
    }
}