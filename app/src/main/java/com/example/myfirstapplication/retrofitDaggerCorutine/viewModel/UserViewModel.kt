package com.example.myfirstapplication.retrofitDaggerCorutine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myfirstapplication.retrofitDaggerCorutine.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val users = liveData {
        val result = userRepository.getUsers()
        emit(result)
    }
}