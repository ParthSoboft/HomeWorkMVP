package com.imaginato.homeworkmvp.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.imaginato.homeworkmvp.R
import com.imaginato.homeworkmvp.data.local.login.Login
import com.imaginato.homeworkmvp.data.local.login.LoginDataBase
import com.imaginato.homeworkmvp.data.remote.demo.request.LoginRequest
import com.imaginato.homeworkmvp.databinding.ActivityLoginBinding
import com.imaginato.homeworkmvp.mvvm.viewmodel.LoginViewModel
import com.imaginato.homeworkmvp.utils.getViewModel
import com.imaginato.homeworkmvp.utils.hideViews
import com.imaginato.homeworkmvp.utils.showViews
import com.imaginato.homeworkmvp.utils.toast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding
    lateinit var db: LoginDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = getViewModel()

        db = LoginDataBase.getInstance(this)

        binding.edtUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtUsername.text.isNullOrEmpty()) {
                    showViews(binding.txtErrorUsename)
                } else {
                    hideViews(binding.txtErrorUsename)
                }

                if (binding.edtPassword.text.isNullOrEmpty()) {
                    showViews(binding.txtErrorPassword)
                } else {
                    hideViews(binding.txtErrorPassword)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtUsername.text.isNullOrEmpty()) {
                    showViews(binding.txtErrorUsename)
                } else {
                    hideViews(binding.txtErrorUsename)
                }

                if (binding.edtPassword.text.isNullOrEmpty()) {
                    showViews(binding.txtErrorPassword)
                } else {
                    hideViews(binding.txtErrorPassword)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.btnLogin.setOnClickListener {
            hideViews(binding.txtErrorPassword)
            hideViews(binding.txtErrorUsename)
            if (binding.edtUsername.text.isNullOrEmpty() && binding.edtPassword.text.isNullOrEmpty()) {
                showViews(binding.txtErrorUsename)
                showViews(binding.txtErrorPassword)
            } else if (binding.edtUsername.text.isNullOrEmpty()) {
                showViews(binding.txtErrorUsename)
            } else if (binding.edtPassword.text.isNullOrEmpty()) {
                showViews(binding.txtErrorPassword)
            } else {
                hideViews(binding.txtErrorPassword)
                hideViews(binding.txtErrorUsename)
                sendLoginData()
            }
        }
    }

    private fun sendLoginData() {

        showViews(binding.pbLoading)

        val headers = HashMap<String, String>()
        headers["IMSI"] = "357175048449937"
        headers["IMEI"] = "510110406068589"

        loginViewModel.performLogin(
            LoginRequest(
                binding.edtUsername.text.toString(), binding.edtPassword.text.toString()
            ), headers
        )

        loginViewModel.message.observe(this) {
            hideViews(binding.pbLoading)
            toast(it)
        }

        loginViewModel.getLoginLiveData().observe(this) {
            hideViews(binding.pbLoading)
            it?.let { loginResponse ->
                if (loginResponse.errorCode == "00" && loginResponse.data != null) {
                    db.LoginDao().insertDemo(
                        Login(
                            loginResponse.data!!.isDeleted ?: false,
                            (loginResponse.data!!.userId ?: "").toInt(),
                            loginResponse.data!!.userName ?: "",
                            getString(R.string.key_x_acc)
                        )
                    )
                }
            }
        }
    }
}