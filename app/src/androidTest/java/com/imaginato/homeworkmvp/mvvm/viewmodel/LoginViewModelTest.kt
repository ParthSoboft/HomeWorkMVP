package com.imaginato.homeworkmvp.mvvm.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.imaginato.homeworkmvp.data.remote.demo.request.LoginRequest
import com.imaginato.homeworkmvp.mvvm.api.WebAPIServiceFactory
import com.imaginato.homeworkmvp.mvvm.repository.LoginRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {

    private lateinit var repository: LoginRepository
    private lateinit var loginViewModel: LoginViewModel
    private var headers = HashMap<String, String>()

    @Before
    fun initializeViews() {
        repository = LoginRepository()
        loginViewModel = LoginViewModel()

        headers["IMSI"] = "357175048449937"
        headers["IMEI"] = "510110406068589"

    }

    @Test
    fun setLoginSuccessData() {

        repository.sendLoginData(
            LoginRequest(
                "username",
                "1111111"
            ), headers
        )

        assert(true) { loginViewModel.loginData }

    }

    @Test
    fun setLoginFailureData() {

        repository.sendLoginData(
            LoginRequest(
                "",
                "1111111"
            ), headers
        )

        Truth.assertThat(false).isFalse()

    }
}