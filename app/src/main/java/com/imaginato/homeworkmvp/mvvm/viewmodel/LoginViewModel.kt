package com.imaginato.homeworkmvp.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imaginato.homeworkmvp.data.remote.demo.request.LoginRequest
import com.imaginato.homeworkmvp.mvvm.network.response.LoginResponse
import com.imaginato.homeworkmvp.mvvm.repository.LoginRepository

class LoginViewModel : ViewModel() {

    private var loginRepository: LoginRepository = LoginRepository()
    var loginData = MutableLiveData<LoginResponse?>()
    var message = MutableLiveData<String>()

    init {
        loginData = loginRepository.getLoginLiveData()
        message=loginRepository.message
    }

    fun performLogin(loginRequest: LoginRequest, headers: HashMap<String, String>) {
        loginRepository.sendLoginData(loginRequest, headers)
    }

    fun getLoginLiveData(): MutableLiveData<LoginResponse?> {
        return loginData
    }

}





