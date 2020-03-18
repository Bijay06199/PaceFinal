package com.example.projectsetup.base

import com.google.gson.annotations.SerializedName

class BaseResponse<T>{

     @SerializedName("message")
     var message:String?=null

    @SerializedName("data")
     var data:T?=null


}

