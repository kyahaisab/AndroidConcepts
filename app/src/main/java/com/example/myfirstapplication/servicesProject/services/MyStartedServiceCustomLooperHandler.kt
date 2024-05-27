package com.example.myfirstapplication.servicesProject.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.util.Log

class MyStartedServiceCustomLooperHandler : Service() {

    private lateinit var serviceHandler: Handler
    private lateinit var handlerThread: HandlerThread

    // Without using this service was not stopping, unless completed
    private var isRunning =
        true // you should make sure that any running tasks or threads are also stopped.

    override fun onCreate() {
        super.onCreate()
        Log.d("MyStartedService", "Service Created")

        // Create and start a new HandlerThread
        handlerThread = HandlerThread("MyHandlerThread")
        handlerThread.start()

        // Create a handler attached to the HandlerThread's Looper
        serviceHandler = Handler(handlerThread.looper)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyStartedService", "Service Started")
        serviceHandler.post {
            // Perform long-running operations here
            for (i in 1..10) {
                if (!isRunning) break
                Log.d("MyStartedService", "Counter: $i")
                Thread.sleep(1000)
            }
            stopSelf()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        handlerThread.quitSafely() // Clean up the HandlerThread
        Log.d("MyStartedService", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
