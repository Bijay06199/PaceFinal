package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class AgentListViewModel:BaseViewModel() {

    val ivBackClick=SingleLiveEvent<Unit>()

    fun onBack(){

        ivBackClick.call()
    }
}