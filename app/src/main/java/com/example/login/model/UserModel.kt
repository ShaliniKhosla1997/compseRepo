package com.example.login.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_table")
data class UserModel(

    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "password_text")
    var passwrd: String
)