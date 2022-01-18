package com.example.login.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.login.dao.RagisterDao
import com.example.login.database.YMLRoomDatabase
import com.example.login.model.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RegisterRepository(context: Context) {
    private var registerDao: RagisterDao
    var usersList: LiveData<List<UserModel>>

    init {
        val db = YMLRoomDatabase.getInstance(context)
        registerDao = db.registerDao
        usersList=registerDao.getAllUsers()
    }

    suspend fun insertUser(userModel: UserModel) {
        val asyncValue=CoroutineScope(Dispatchers.IO).async {
            registerDao.insertData(userModel)
        }
        if(asyncValue.isCompleted){
            Log.d("dh","Completed")
        }
        Log.d("dh",asyncValue.await().toString())
    }

    suspend fun getUserName(userName: String): UserModel {
        var userModel: UserModel? = null
        CoroutineScope(Dispatchers.IO).launch {
            userModel = registerDao.getUserName(userName)
        }
        return userModel!!
    }

    fun getALlUsers(): LiveData<List<UserModel>> {
        return usersList
    }
}