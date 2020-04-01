package com.example.projectsetup.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectsetup.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    val alertDialogEvent = SingleLiveEvent<String>()
    val showToastEvent = SingleLiveEvent<String>()
    val showLoading = SingleLiveEvent<Boolean>()
    val checked = SingleLiveEvent<Boolean>()

    fun showToast(message: String) {
        showToastEvent.value = message
    }

    fun showAlertDialog(message: String) {
        alertDialogEvent.value = message
    }

    fun showLoading(status: Boolean) {
        showLoading.value = status
    }

    fun checked(status: Boolean) {
        checked.value = status
    }


    private var job: Job? = null
    fun <T : Any?> launchWithDebounce(
        coroutineScope: CoroutineScope = viewModelScope,
        debounceTimeInMillis: Long = 400,
        codeBlock: suspend CoroutineScope.() -> T
    ) {
        job?.cancel()
        val currentJob = coroutineScope.launch {
            // add delay from second request
            if (job != null) {
                delay(debounceTimeInMillis)
            }
            codeBlock()
        }
        job = currentJob
    }

}