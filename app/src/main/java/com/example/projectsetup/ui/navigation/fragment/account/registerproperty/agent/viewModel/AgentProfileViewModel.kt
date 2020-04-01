package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel

import androidx.lifecycle.ViewModel
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class AgentProfileViewModel : BaseViewModel() {

    val ivBackClickEvent= SingleLiveEvent<Unit>()

    fun back(){
        ivBackClickEvent.call()
    }
}


