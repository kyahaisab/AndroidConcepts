package com.example.myfirstapplication.servicesProject.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

// A simple background timer
class MyStartedService : Service() {

    private val handler = Handler()
    private var counter = 0
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            counter++
            Log.d("MyStartedService", "Counter: $counter")
            handler.postDelayed(
                this,
                1000
            ) // Schedule next execution, calling itself again and again
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MyStartedService", "Service Created")
    }

    /*
1. The onStartCommand method must return an integer to indicate how the system should handle the service if it's killed while starting.

START_STICKY: The service is restarted if it gets terminated. The Intent data passed to onStartCommand is null on restart.
START_NOT_STICKY: The service is not restarted if it gets terminated.
START_REDELIVER_INTENT: The service is restarted if it gets terminated, and the last Intent is redelivered.

2. If your service performs long-running operations, consider using separate threads to prevent blocking the main thread.
For example, you can use a HandlerThread or AsyncTask.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyStartedService", "Service Started")
        handler.post(runnable) // Start the counter
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable) // Stop the counter
        Log.d("MyStartedService", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // We don't provide binding, so return null
        return null
    }
}