package com.example.myfirstapplication.otherTerminology

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/*
1. Garbage Collection Process: When you create objects in Kotlin, memory is allocated for them.
When these objects are no longer needed or referenced by any part of your program,
they become eligible for garbage collection.

2. A memory leak occurs when memory that is no longer needed by an application is not released,
leading to a gradual depletion of available memory

causes:
-Another object holds a reference to the first object, either directly or indirectly.
-Even when the first object is no longer needed for the application's logic,
the reference to it prevents it from being garbage collected.

prevention:
-Ensure that objects are released or set to null when they are no longer needed.
-Avoid Static References: as they can keep objects in memory for the entire lifetime of the application.
-Use Memory Profiling Tools: to identify potential memory leaks in your application

Example:
Activity/Fragment References: In Android development with Kotlin, holding references to
Activities or Fragments in long-lived objects (like singletons or background threads) can lead to memory leaks. For example:

object MySingleton {
    private var activity: Activity? = null

    fun setActivityReference(activity: Activity) {
        this.activity = activity
    }
}

If MySingleton holds a reference to an Activity, and the Activity is destroyed (like during a configuration change, new instance is created),
the Activity object won't be garbage collected because it's still referenced by the singleton.
 */

// Example
// To fix the potential memory leak caused by the listener callback, you need to
// ensure that the listener is unregistered when it's no longer needed.

class MyActivity : AppCompatActivity() {
    private val myListener = MyListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // Register the listener
        myListener.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister the listener to prevent memory leak
        myListener.stopListening()
    }
}

class MyListener {
    private var listener: Listener? = null // Store the reference to the listener

    fun startListening() {
        listener = object : Listener {
            override fun onEvent() {
                // Handle event
            }
        }
        SomeManager.addListener(listener!!)
    }

    // This method should be called when the listener is no longer needed
    fun stopListening() {
        SomeManager.removeListener(listener) // Remove the listener
        listener = null // Release the reference
    }
}

interface Listener {
    fun onEvent()
}

object SomeManager {
    private var listener: Listener? = null

    fun addListener(listener: Listener) {
        this.listener = listener
    }

    fun removeListener(listener: Listener?) {
        if (this.listener == listener) {
            this.listener = null
        }
    }
}


