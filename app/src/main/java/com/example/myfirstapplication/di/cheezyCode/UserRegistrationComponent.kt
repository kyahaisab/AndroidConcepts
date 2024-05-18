package com.example.myfirstapplication.di.cheezyCode

import dagger.Component

@Component
interface UserRegistrationComponent {
    fun getUserRegistrationService(): UserRegistrationService

    fun getEmailService(): EmailService
}