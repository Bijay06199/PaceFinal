package com.example.projectsetup.ui.login

import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


private const val BASE_URL = "http:test.com/"
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
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PaceApi {
    val retrofitService : PaceApiService by lazy { retrofit.create(PaceApiService::class.java) }
}