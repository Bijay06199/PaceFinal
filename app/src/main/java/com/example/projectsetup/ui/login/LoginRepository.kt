package com.example.projectsetup.ui.login

import com.example.projectsetup.base.BaseResponse
import com.example.projectsetup.data.api.ApiServices
import com.example.projectsetup.data.error.BlankResponseException
import com.example.projectsetup.data.prefs.PreferenceManager
import java.lang.Exception
import com.example.projectsetup.utils.Result
import org.json.JSONObject

interface LoginRepository {

    suspend fun login(email: String, password: String): Result<BaseResponse<UserBody>>
}

class LoginRepositoryImpl(
    private val apiServices: ApiServices,
    private val preferenceManager: PreferenceManager
) : LoginRepository {
    override suspend fun login(email: String, password: String): Result<BaseResponse<UserBody>> {
        return try {
            val request = LoginRequestModel(email, password)
            val response = apiServices.login(request)
            //code
            if (response.isSuccessful) {
                if (response.body() != null) {
                    preferenceManager.setToken(response.body()!!.token!!)
                    preferenceManager.setIsLoggedIn(response.body()!!.token != null)
                    Result.Success(response.body()!!)
                } else {
                    Result.Error(BlankResponseException("Failed to receive data from the server"))
                }
            } else {
                val jsonObject = JSONObject(response.errorBody()!!.string())
                Result.Progress(jsonObject.optString("message"), response.code())
            }

        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}