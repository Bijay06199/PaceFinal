package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class RegisterPropertyRentPriceViewModel:BaseViewModel() {
    val btnNextClicked=SingleLiveEvent<Unit>()
    val ivBackClicked=SingleLiveEvent<Unit>()

    fun onNext(){
        btnNextClicked.call()
    }

    fun onBack(){

        ivBackClicked.call()
    }




}
