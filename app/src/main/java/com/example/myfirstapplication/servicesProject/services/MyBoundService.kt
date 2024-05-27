package com.example.myfirstapplication.servicesProject.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlin.random.Random

/*
*****Overview of Bound Services-Bound services can be created in several ways:

Local Binding: The service is only accessible by clients within the same application.
Remote Binding: The service can be accessed by clients in other applications via IPC (Inter-Process Communication).

*****Key Methods in a Bound Service
onBind(intent: Intent): IBinder: Called when a client binds to the service. Must return an IBinder
object that defines the interface for clients to interact with the service.
*
onUnbind(intent: Intent): Called when all clients have disconnected from a particular interface published by the service.
 */

class MyBoundService : Service() {

    // Binder given to clients
    private val binder = LocalBinder()

    // Random number generator
    private val randomGenerator = Random(System.currentTimeMillis())

    // Class used for the client Binder.
    //LocalBinder is a class that extends Binder and provides a method to get the current
    // instance of the service. This allows clients to call public methods in the service.
    inner class LocalBinder : Binder() {
        // Return this instance of MyBoundService so clients can call public methods
        fun getService(): MyBoundService = this@MyBoundService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    // Public method that clients can call to get a random number.
    fun getRandomNumber(): Int {
        return randomGenerator.nextInt(100)
    }
}
