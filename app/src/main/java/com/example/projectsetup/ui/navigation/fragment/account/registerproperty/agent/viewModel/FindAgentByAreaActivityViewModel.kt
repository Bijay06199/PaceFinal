package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class FindAgentByAreaActivityViewModel:BaseViewModel() {

    val ivBackClicked=SingleLiveEvent<Unit>()
    val iconNextClicked=SingleLiveEvent<Unit>()

    fun onBack(){
        ivBackClicked.call()
    }

    fun onNextClicked(){
        iconNextClicked.call()
    }
}