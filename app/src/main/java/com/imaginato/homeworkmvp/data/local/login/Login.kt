package com.imaginato.homeworkmvp.data.local.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Login(
    @ColumnInfo(name = "isDeleted") var isDeleted: Boolean = false,
    @PrimaryKey
    @ColumnInfo(name = "userId") var userId: Int = 0,
    @ColumnInfo(name = "userName") var userName: String = "",
    @ColumnInfo(name = "X-Acc") var x_Acc: String = "",
)