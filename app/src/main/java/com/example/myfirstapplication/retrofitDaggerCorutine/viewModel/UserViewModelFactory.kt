package com.example.myfirstapplication.retrofitDaggerCorutine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapplication.retrofitDaggerCorutine.repository.UserRepository

//The UserViewModelFactory class implements the ViewModelProvider.Factory interface, which is used to create instances of ViewModel
class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    //<T : ViewModel>: This specifies that the method is generic and works with any type T that is a subclass of ViewModel.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // This checks if the modelClass is the same as or a superclass of UserViewModel.
        // Essentially, it verifies whether the requested ViewModel is a UserViewModel.
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}