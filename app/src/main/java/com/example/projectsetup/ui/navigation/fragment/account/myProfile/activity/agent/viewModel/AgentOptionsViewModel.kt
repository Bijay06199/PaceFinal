package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class AgentOptionsViewModel:BaseViewModel() {

    val newRealEstateClickedEvent=SingleLiveEvent<Unit>()
    val existingRealEstateClickedEvent=SingleLiveEvent<Unit>()
    val nextClickedEvent=SingleLiveEvent<Unit>()
    val backClickedEvent=SingleLiveEvent<Unit>()



    fun newRealEstate(){
        newRealEstateClickedEvent.call()
    }

    fun existingRealEstate(){
        existingRealEstateClickedEvent.call()
    }
    fun next(){
        nextClickedEvent.call()
    }

    fun back(){
        backClickedEvent.call()
    }

}