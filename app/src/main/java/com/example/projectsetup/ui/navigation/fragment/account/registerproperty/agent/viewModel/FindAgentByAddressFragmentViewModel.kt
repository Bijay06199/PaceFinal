package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class FindAgentByAddressFragmentViewModel:BaseViewModel() {

    val btnFindAgentClicked=SingleLiveEvent<Unit>()
    val ivBackClicked=SingleLiveEvent<Unit>()

    fun onBtnClicked(){
        btnFindAgentClicked.call()

    }

    fun onBackClicked(){
        ivBackClicked.call()


    }
}