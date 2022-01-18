package com.example.login.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.model.UserModel
import com.example.login.repo.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RagisterViewModel @Inject constructor(application: Application): ViewModel() {
     var registerRepository: RegisterRepository

    init {
        registerRepository=RegisterRepository(application)
    }

    fun insert(user: UserModel): Job = viewModelScope.launch {
        registerRepository.insertUser(user)
    }
//    suspend fun getUserName(userName: String): UserModel?{
//        return registerRepository.getUserName(userName)
//    }

    fun getALlUsers (): LiveData<List<UserModel>> {
        return  registerRepository.getALlUsers()
    }


}
