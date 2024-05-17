package com.example.myfirstapplication.di.cheezyCode

class UserRegistration(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {

    internal fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "Shivsagarhbtu@gmail.com", "User Registered")
    }
}