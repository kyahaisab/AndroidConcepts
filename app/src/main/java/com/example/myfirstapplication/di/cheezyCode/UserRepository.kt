package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import javax.inject.Inject


interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(BaseDIActivity.TAG, "User saved in DB")
    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(BaseDIActivity.TAG, "User saved in Firebase")
    }

}