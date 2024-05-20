package com.example.myfirstapplication.di.cheezyCode

import android.app.Application
import com.example.myfirstapplication.di.cheezyCode.component.AppComponent
import com.example.myfirstapplication.di.cheezyCode.component.DaggerAppComponent

class UserApplication : Application() {

    // Our singleton level is same as component level, as this class is application level, so singletons using this component
    // are of app component level
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}