package com.imaginato.homeworkmvp.mvvm.repository

import android.os.Message
import androidx.lifecycle.MutableLiveData
import com.imaginato.homeworkmvp.data.remote.demo.request.LoginRequest
import com.imaginato.homeworkmvp.mvvm.api.WebAPIService
import com.imaginato.homeworkmvp.mvvm.api.WebAPIServiceFactory
import com.imaginato.homeworkmvp.mvvm.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginRepository {

    var repository: WebAPIService = WebAPIServiceFactory.newInstance().makeServiceFactory()
    var loginData = MutableLiveData<LoginResponse?>()
    var message = MutableLiveData<String>()

    fun sendLoginData(loginRequest: LoginRequest, headers: HashMap<String, String>) {
        repository.sendLoginData(loginRequest, headers).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginData.value = response.body()
                message.value = response.body()!!.errorMessage!!

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginData.value = null
                message.value = t.message
            }
        })
    }

    fun getLoginLiveData(): MutableLiveData<LoginResponse?> {
        return loginData
    }



}