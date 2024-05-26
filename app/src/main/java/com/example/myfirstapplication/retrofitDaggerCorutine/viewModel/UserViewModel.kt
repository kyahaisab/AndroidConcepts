package com.example.myfirstapplication.retrofitDaggerCorutine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myfirstapplication.retrofitDaggerCorutine.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val users = liveData {
        val result = userRepository.getUsers()
        emit(result)

        /*
        Initializes this property with a LiveData instance. The liveData builder function is a coroutine
        that provides a lifecycle-aware LiveData instance. This allows the UserViewModel to expose data
        that can be observed by the UI components.

        emit(result): This suspending function emits the retrieved result (list of users) as a new value to the LiveData
         */
    }
}