package com.example.projectsetup.utils.networkUtils

import com.example.projectsetup.utils.contracts.AppContracts.NetworkCodes.NO_CONTENT_FOUND
import com.example.projectsetup.utils.contracts.AppContracts.NetworkCodes.NO_INTERNET_CONNECTION
import org.json.JSONObject
import retrofit2.HttpException
import java.net.*

fun Exception.handleException(
        onErrorBlock: (errorResponse: ErrorResponse) -> Unit) {
    printStackTrace()
    when (this) {
        is UnknownHostException -> onErrorBlock(ErrorResponse("No internet connection.Please check your network connection and try again.", NO_INTERNET_CONNECTION))
        is ConnectException -> onErrorBlock(ErrorResponse("No internet connection.Please check your network connection and try again.", NO_INTERNET_CONNECTION))
        is SocketTimeoutException -> onErrorBlock(ErrorResponse("Server request time out"))
        is NoSuchElementException -> onErrorBlock(ErrorResponse("Something went wrong"))
        is SocketException -> onErrorBlock(ErrorResponse("Server error"))
        is HttpException ->
            try {
                val responseBody = response()?.errorBody()
                val jsonObject = JSONObject(responseBody?.string())

                when (code()) {
                    HttpURLConnection.HTTP_SEE_OTHER -> {
                        onErrorBlock(ErrorResponse(jsonObject.optString("message"), HttpURLConnection.HTTP_SEE_OTHER))
                    }
                    HttpURLConnection.HTTP_CONFLICT -> {
                        onErrorBlock(ErrorResponse(jsonObject.optString("message"), HttpURLConnection.HTTP_CONFLICT))
                    }
                    else -> {
                        if (jsonObject.has("message")) {
                            onErrorBlock(ErrorResponse(jsonObject.optString("message"), code()))
                        } else {
                            onErrorBlock(ErrorResponse("Something went wrong", code()))
                        }
                    }
                }
            } catch (e: Exception) {
                if (e !is NullPointerException)
                    onErrorBlock(ErrorResponse("Something went wrong"))
                else
                    onErrorBlock(ErrorResponse("Something went wrong", NO_CONTENT_FOUND))
            }
        else -> {
            onErrorBlock(ErrorResponse("Something went wrong"))
        }
    }
}

data class ErrorResponse(val message: String, val errorCode: Int = -1)


