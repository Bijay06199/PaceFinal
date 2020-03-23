package com.example.projectsetup.ui.login

import android.text.InputType
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseViewModel
import com.example.projectsetup.utils.Result
import com.example.projectsetup.utils.SingleLiveEvent
import com.example.projectsetup.utils.networkUtils.handleException
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    val email: String = ""
    val password: String = ""
    val forgotPassword: String = ""
    val login: String = ""
    val orloginwith: String = ""
    val donthaveanaccout: String = ""
    val register: String = ""
    val loginSuccessEvent=SingleLiveEvent<Unit>()

    fun login(email: String, password: String) {
        showLoading.value = true
        //background tasks for async
        viewModelScope.launch {
            loginRepository.login(email, password).apply {
                showLoading.value = false
                when (this) {
                    is Result.Success ->
                    {
                        loginSuccessEvent.call()

                    }
                    is Result.Progress->{
                        when(this.code){
                            400 -> {
                                showAlertDialog(this.errorMessage)
                            }
                            else -> {
                                showAlertDialog(this.errorMessage)
                            }
                        }
                    }
                    is Result.Error->{
                        this.exception.handleException {
                            showAlertDialog(it.message)
                        }
                    }

                }
            }
        }
    }


    fun onclick() {


    }


}