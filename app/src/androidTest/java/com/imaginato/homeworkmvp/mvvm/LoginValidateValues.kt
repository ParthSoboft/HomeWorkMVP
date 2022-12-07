package com.imaginato.homeworkmvp.mvvm

object LoginValidateValues {

    fun validateLoginInput(
        userName : String,
        password : String,
    ) : Boolean {
        if (userName.isEmpty() || password.isEmpty()){
            return false
        }
        return true
    }
}
