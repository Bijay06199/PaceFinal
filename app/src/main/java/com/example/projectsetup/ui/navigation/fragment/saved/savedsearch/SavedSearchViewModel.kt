package com.example.projectsetup.ui.navigation.fragment.saved.savedsearch

import androidx.lifecycle.ViewModel
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class SavedSearchViewModel : BaseViewModel() {
    val saved:String=""
    val haventsaved:String=""
    val searching:String=""
    val getstarted:String=""

    val clickedEvent= SingleLiveEvent<Unit>()

    fun next(){
        clickedEvent.call()
    }
}
