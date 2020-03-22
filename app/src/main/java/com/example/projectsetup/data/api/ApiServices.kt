package com.example.projectsetup.data.api

import com.example.projectsetup.base.BaseResponse
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRequestModel
import com.example.projectsetup.ui.login.LoginRequestModel
import com.example.projectsetup.ui.login.UserBody
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {
    @FormUrlEncoded
    @POST("user/information")
    suspend fun postInformation(@Header("token")token:String,@Field("id")id:Int)

    @POST("user/information")
    suspend fun forgotPassword(@Header("token")token:String,@Body requestModel:ForgotPasswordRequestModel)
            :BaseResponse<Nothing>

    @POST("api/v1/en/user/login")
    suspend fun login(@Body request: LoginRequestModel):Response<BaseResponse<UserBody>>


}