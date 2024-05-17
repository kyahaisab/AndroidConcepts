package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity

class UserRepository {
    fun saveUser(email: String, password: String) {
        Log.d(BaseDIActivity.TAG, "User saved in DB")
    }
}