package com.example.myfirstapplication.servicesProject.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat

/*
A foreground service is a service that the user is actively aware of and is not a candidate for the system to kill when low on memory.
Foreground services must display a status bar notification, ensuring that the user is actively aware of the service.

Key Steps for Implementing a Foreground Service
Create the Service Class: Extend the Service class and implement the necessary methods.
Create a Notification: Foreground services require a notification to be displayed.
Start the Foreground Service: Use the startForeground() method.
Handle Permissions: Request the necessary permissions for notifications (if targeting Android 13 or above).
Stop the Foreground Service: Use the stopForeground() and stopSelf() methods.

We'll create a simple foreground service that performs a task (e.g., counting) in the background while displaying a notification.
 */
class MyForegroundService : Service() {

    private val CHANNEL_ID = "ForegroundServiceChannel"
    private var isRunning = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private var counter = 0

    override fun onCreate() {
        super.onCreate()
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            if (isRunning) {
                counter++
                // Update the notification
                val notification = createNotification("Counter: $counter")
                startForeground(1, notification)
                handler.postDelayed(runnable, 1000)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val notification = createNotification("Service is running...")
        startForeground(1, notification)

        isRunning = true
        handler.post(runnable)

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        handler.removeCallbacks(runnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotification(contentText: String): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service Example")
            .setContentText(contentText)
            .setSmallIcon(com.google.android.material.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }
}
