package com.example.myfirstapplication.di.cheezyCode

import com.example.myfirstapplication.di.cheezyCode.annotations.MessageQualifier
import com.example.myfirstapplication.di.cheezyCode.basicFunction.NotificationService
import com.example.myfirstapplication.di.cheezyCode.basicFunction.UserRepository
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier private val notificationService: NotificationService // we are avoiding typo by avoiding @Named("message")
) {

    internal fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "Shivsagarhbtu@gmail.com", "User Registered")
    }
}