package com.example.projectsetup.ui.navigation

import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.SingleLiveEvent

class NavigationViewModel:BaseViewModel() {

    val home:String=""
    val saved:String=""
    val search:String=""
    val chat:String=""
    val account:String=""

    val txtHomeClicked=SingleLiveEvent<Unit>()
    val txtSavedClicked=SingleLiveEvent<Unit>()
    val txtSearchClicked=SingleLiveEvent<Unit>()
    val fabClicked=SingleLiveEvent<Unit>()
    val txtChatClicked=SingleLiveEvent<Unit>()
    val txtAccountClicked=SingleLiveEvent<Unit>()

    fun onHomeClicked0(){
        txtHomeClicked.call()

    }
    fun onSavedClicked(){
        txtSavedClicked.call()
    }

    fun onSearchClicked(){
        txtSearchClicked.call()
    }
    fun onFabClicked(){
        fabClicked.call()
    }
    fun onChatClicked(){
        txtChatClicked.call()
    }
    fun onAccountClicked(){
        txtAccountClicked.call()
    }



}