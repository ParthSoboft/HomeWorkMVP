package com.imaginato.homeworkmvp.data.local.login

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface LoginDao {
     @Insert(onConflict = OnConflictStrategy.REPLACE)
       fun insertDemo(demo:Login)
}