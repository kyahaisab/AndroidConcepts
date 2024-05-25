package com.example.myfirstapplication.retrofitDaggerCorutine.di

import android.app.Application
import com.example.myfirstapplication.retrofitDaggerCorutine.di.component.AppComponentOne
import com.example.myfirstapplication.retrofitDaggerCorutine.di.component.DaggerAppComponentOne
import com.example.myfirstapplication.retrofitDaggerCorutine.di.modules.NetworkModule
import com.example.myfirstapplication.retrofitDaggerCorutine.di.modules.RepositoryModule

class MyApplicationOne : Application() {
    lateinit var appComponentOne: AppComponentOne

    override fun onCreate() {
        super.onCreate()
        appComponentOne = DaggerAppComponentOne.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}