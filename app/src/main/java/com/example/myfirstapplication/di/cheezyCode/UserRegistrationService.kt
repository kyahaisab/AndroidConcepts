package com.example.myfirstapplication.di.cheezyCode

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val notificationService: NotificationService
) {

    internal fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "Shivsagarhbtu@gmail.com", "User Registered")
    }
}