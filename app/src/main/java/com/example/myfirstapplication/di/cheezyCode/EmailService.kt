package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import javax.inject.Inject

class EmailService @Inject constructor(){
    fun send(to: String, from: String, body: String?) {
        Log.d(BaseDIActivity.TAG, "Mail sent")
    }
}