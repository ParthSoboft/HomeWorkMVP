package com.imaginato.homeworkmvp.data.local.login

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Login::class], version = 1, exportSchema = false)
abstract class LoginDataBase : RoomDatabase() {
    abstract fun LoginDao(): LoginDao
    companion object {
        @Volatile
        var instance: LoginDataBase? = null
        fun getInstance(context: Context): LoginDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context,LoginDataBase::class.java,"Login.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as LoginDataBase
        }
    }
}


