package com.example.login.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.login.model.UserModel

@Dao
interface RagisterDao {

    @Insert
     fun insertData(user: UserModel)

    @Query("SELECT * FROM Register_table ORDER BY userId DESC")
    fun getAllUsers():LiveData<List<UserModel>>

    @Query("SELECT * FROM Register_table WHERE user_name = :userName")
    fun getUserName(userName : String):UserModel
}