package com.imaginato.homeworkmvp.mvvm.api

import com.imaginato.homeworkmvp.data.remote.demo.request.LoginRequest
import com.imaginato.homeworkmvp.mvvm.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST


const val BASE_URL = "http://private-222d3-homework5.apiary-mock.com/api/"
const val Login_URL = "login"

interface WebAPIService {

    @POST(Login_URL)
    fun sendLoginData(
        @Body body: LoginRequest,
        @HeaderMap headers: HashMap<String, String>,
    ): Call<LoginResponse>
}

