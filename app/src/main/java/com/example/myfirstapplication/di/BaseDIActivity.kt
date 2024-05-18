package com.example.myfirstapplication.di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R
import com.example.myfirstapplication.di.cheezyCode.DaggerUserRegistrationComponent

class BaseDIActivity : AppCompatActivity() {
    companion object {
        public const val TAG = "DI Implementation"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_diactivity)


        val component = DaggerUserRegistrationComponent.builder().build()
        val userRegistration = component.getUserRegistrationService()
        val emailService = component.getEmailService()
        userRegistration.registerUser("Sagardawn145@gmail.com", "Maosetun1@98ee")
    }
}