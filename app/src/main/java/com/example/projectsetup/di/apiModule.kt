package com.example.projectsetup.di

import androidx.lifecycle.LiveData
import com.example.projectsetup.BuildConfig
import com.example.projectsetup.data.api.ApiServices
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single {
        createOkHttpClient()
    }

    single {

        createRetrofit<ApiServices>(get())
    }
}

fun createOkHttpClient(): OkHttpClient {

    val httpLoginInterceptor = HttpLoggingInterceptor()

    httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()

        .connectTimeout(20L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoginInterceptor).build()


}

inline fun<reified T>createRetrofit(okHttpClient: OkHttpClient):T{

    val retrofit= Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

    return retrofit.create(T::class.java)
}

