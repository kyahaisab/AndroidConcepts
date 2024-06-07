package com.example.myfirstapplication.amitSekhar.shortQuestions

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

private suspend fun timeTakingTask() {
    // from here task will be switched from our custom thread to IO thread making custom thread free to do something
    withContext(Dispatchers.IO) {
        // Do time taking task
        Thread.sleep(5000)
    }
}

// Ensuring only one thread
private val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

/*private fun testSuspending() {
    lifecyclescope.launch(dispatcher) {
        Log.d("TEST", "test suspending before task 1")
        timeTakingTask()
        Log.d("TEST", "test suspending after task 1")
    }
    lifecyclescope.launch(dispatcher) {
        Log.d("TEST", "test suspending before task 2")
        timeTakingTask()
        Log.d("TEST", "test suspending after task 2")
    }
}*/

/*private fun testBlocking() {
    lifecyclescope.launch(dispatcher) { // our custom dispatcher is not allowed to do something, when our code inside runBlocking is executed, though dispatcher is free but its not doing anything
        runBlocking {
            Log.d("TEST", "test suspending before task 1")
            timeTakingTask()
            Log.d("TEST", "test suspending after task 1")
        }
    }
    lifecyclescope.launch(dispatcher) {
        runBlocking {
            Log.d("TEST", "test suspending before task 2")
            timeTakingTask()
            Log.d("TEST", "test suspending after task 2")
        }
    }
}*/

/*fun main() {
    testSuspending()
    //OP: before task 1->before task2->after task 1->after task 2
}*/

/*
fun main() {
    testBlocking()
    //OP: before task 1-> after task 1-> before task 2-> after task 2
}*/
