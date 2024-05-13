package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {// Execute in main thread
// Note work done in KotlinCoroutine1 file is same as this file
    runBlocking {// creates a coroutine that blocks the current main thread
        println("Main program starts: ${Thread.currentThread().name}") // main thread

        GlobalScope.launch { // On thread T1
            println("Fake work start: ${Thread.currentThread().name}")
            delay(1000)// coroutine is suspended but Thread T1 is free(not blocked)
            println("Fake work completed: ${Thread.currentThread().name}") // may be T1 or other thread
        }
        delay(2000)// Main thread wait for coroutine to finish

        println("Main program Ended: ${Thread.currentThread().name}") // amin thread
    }
}