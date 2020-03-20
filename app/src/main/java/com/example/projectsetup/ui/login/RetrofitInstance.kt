package com.example.projectsetup.ui.login

import com.example.projectsetup.ui.register.RegisterBody
import com.example.projectsetup.ui.register.SignUpBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


private const val BASE_URL = "http://test.com/"
enum class MarsApiFilter(val value: String) { SHOW_RENT("rent"), SHOW_BUY("buy"), SHOW_ALL("all") }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PaceApiService {

    @Headers("Content-Type:application/json")
    @POST("api/v1/en/user/login")
    fun signIn(
        @Body info: SignInBody
    ): Call<UserBody>
    @POST("api/v1/en/user/signup")
    fun signUp(@Body info: SignUpBody):Call<RegisterBody>

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PaceApi {
    val retrofitService : PaceApiService by lazy { retrofit.create(PaceApiService::class.java) }
}