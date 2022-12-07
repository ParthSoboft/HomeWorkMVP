package com.imaginato.homeworkmvp.mvvm.network.response

data class LoginResponse(
    var data: Data?,
    var errorCode: String?,
    var errorMessage: String?,
) {
    data class Data(
        var isDeleted: Boolean?,
        var userId: String?,
        var userName: String?,
    )
}