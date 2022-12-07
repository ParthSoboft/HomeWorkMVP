package com.imaginato.homeworkmvp.mvvm.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebAPIServiceFactory {

    companion object {
        fun newInstance(): WebAPIServiceFactory {
            return WebAPIServiceFactory()
        }
    }

    fun makeServiceFactory(): WebAPIService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(38000, TimeUnit.SECONDS)
                    .readTimeout(38000, TimeUnit.SECONDS)
                    .addInterceptor(Interceptor { chain ->
                        val newRequest: Request = chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .build()
                        chain.proceed(newRequest)
                    })
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
        return retrofit.create(WebAPIService::class.java)
    }


}