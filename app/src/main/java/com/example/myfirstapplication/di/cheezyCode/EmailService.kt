package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

class EmailService @Inject constructor() : NotificationService {
    override
    fun send(to: String, from: String, body: String?) {
        Log.d(BaseDIActivity.TAG, "Mail sent")
    }
}

class MessageService : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(BaseDIActivity.TAG, "SMS sent")
    }

}