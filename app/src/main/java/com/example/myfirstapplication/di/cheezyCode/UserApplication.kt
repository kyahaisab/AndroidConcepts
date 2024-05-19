package com.example.myfirstapplication.di.cheezyCode

import android.app.Application
import com.example.myfirstapplication.di.cheezyCode.component.DaggerUserRegistrationComponent
import com.example.myfirstapplication.di.cheezyCode.component.UserRegistrationComponent

class UserApplication : Application() {

    // Our singleton level is same as component level, as this class is application level, so singletons using this component
    // are of app component level
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()

        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(3)
    }
}