package com.example.myfirstapplication.di.cheezyCode.basicFunction

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity
import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService {
    override
    fun send(to: String, from: String, body: String?) {
        Log.d(BaseDIActivity.TAG, "Mail sent")
    }
}

class MessageService(private val retryCount: Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(BaseDIActivity.TAG, "SMS sent - retry count :$retryCount")
    }

}