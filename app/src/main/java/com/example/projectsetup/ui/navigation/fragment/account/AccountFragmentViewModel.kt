package com.example.projectsetup.ui.navigation.fragment.account

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class AccountFragmentViewModel:BaseViewModel() {
    val txtRegisterProperty=SingleLiveEvent<Unit>()

    fun onClicked(){

        txtRegisterProperty.call()
    }

}