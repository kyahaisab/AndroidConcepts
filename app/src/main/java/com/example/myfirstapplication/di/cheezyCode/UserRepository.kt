package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository {
    fun saveUser(email: String, password: String)
}

@Singleton
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