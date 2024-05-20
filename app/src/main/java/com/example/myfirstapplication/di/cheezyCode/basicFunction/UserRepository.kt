package com.example.myfirstapplication.di.cheezyCode.basicFunction

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import javax.inject.Inject


interface UserRepository {
    fun saveUser(email: String, password: String)
}

@ActivityScope
class SQLRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(BaseDIActivity.TAG, "User saved in DB")
        analyticsService.trackEvent("Save User", "Create")
    }
}

class FirebaseRepository(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(BaseDIActivity.TAG, "User saved in Firebase")
        analyticsService.trackEvent("Save User", "Create")
    }
}