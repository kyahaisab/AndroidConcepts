package com.example.myfirstapplication.di.cheezyCode

import android.util.Log
import com.example.myfirstapplication.di.BaseDIActivity.Companion.TAG

interface AnalyticsService {
    fun trackEvent(eventType: String, eventName: String)
}

class Mixpanel : AnalyticsService {
    override fun trackEvent(eventType: String, eventName: String) {
        Log.d(TAG, "MixPanel- Event Type: $eventType and Event Name: $eventName")
    }
}

class FirebaseAnalytics : AnalyticsService {
    override fun trackEvent(eventType: String, eventName: String) {
        Log.d(TAG, "Firebase- Event Type: $eventType and Event Name: $eventName")
    }
}