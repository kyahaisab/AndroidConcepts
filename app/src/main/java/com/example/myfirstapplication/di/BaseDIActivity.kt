package com.example.myfirstapplication.di

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R
import com.example.myfirstapplication.di.cheezyCode.EmailService
import com.example.myfirstapplication.di.cheezyCode.UserRegistration
import com.example.myfirstapplication.di.cheezyCode.UserRepository

class BaseDIActivity : AppCompatActivity() {
    companion object {
        public const val TAG = "DI Implementation"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base_diactivity)

        val emailService = EmailService()
        val userRepository = UserRepository()

        // Doing Manual DI
        val userRegistration = UserRegistration(userRepository, emailService)
        userRegistration.registerUser("Sagardawn145@gmail.com", "Maosetun1@98ee")
    }
}