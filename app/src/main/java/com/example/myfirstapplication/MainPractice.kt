package com.example.myfirstapplication

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking { // will run on current thread i.e main thread
        println("Main program starts: ${Thread.currentThread().name}") // main thread

        // launch co routine will inherit thread and scope of immediate parent coroutine
        launch {
            println("Fake work start: ${Thread.currentThread().name}")// main
            delay(1000) // Coroutine is suspended but Thread: main is free
            println("Fake work completed: ${Thread.currentThread().name}") // Either main thread of some other thread
        }

        delay(1500)

        println("Main program Ended: ${Thread.currentThread().name}") // main
    }
}

