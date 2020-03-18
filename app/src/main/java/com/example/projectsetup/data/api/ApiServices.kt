package com.example.projectsetup.data.api

import com.example.projectsetup.base.BaseResponse
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordRequestModel
import retrofit2.http.*

interface ApiServices {
    @FormUrlEncoded
    @POST("user/information")
    suspend fun postInformation(@Header("token")token:String,@Field("id")id:Int)

    @POST("user/information")
    suspend fun forgotPassword(@Header("token")token:String,@Body requestModel:ForgotPasswordRequestModel)
            :BaseResponse<Nothing>


}