package com.example.projectsetup.utils

import com.example.projectsetup.utils.networkUtils.ErrorResponse

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class ErrorTest(val exception: ErrorResponse) : Result<Nothing>()
    data class Progress(val errorMessage: String, val code: Int) : Result<Nothing>()
    object Loading : Result<Nothing>()

}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null
