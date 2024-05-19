package com.example.myfirstapplication.di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R
import com.example.myfirstapplication.di.cheezyCode.DaggerUserRegistrationComponent
import com.example.myfirstapplication.di.cheezyCode.NotificationServiceModule
import com.example.myfirstapplication.di.cheezyCode.UserRegistrationService
import javax.inject.Inject

class BaseDIActivity : AppCompatActivity() {
    companion object {
        public const val TAG = "DI Implementation"
    }

    @Inject  // This annotation will let dagger know that these places you need to pass objects, this is called field injection
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_diactivity)

// Till now dagger was creating object for us by itself, but now we need to pass some value at runtime, so we do below
//        val component = DaggerUserRegistrationComponent
//            .builder()
//            // Say someone forgot to put the below line, so it will create problem at runtime
//            //.notificationServiceModule(NotificationServiceModule(3))
//            .build()

        val component = DaggerUserRegistrationComponent.factory().create(3) // using factory

        component.inject(this)
        userRegistrationService.registerUser("Sagardawn145@gmail.com", "Maosetun1@98ee")
    }
}