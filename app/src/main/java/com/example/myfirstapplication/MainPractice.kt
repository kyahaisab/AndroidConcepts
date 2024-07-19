package com.example.myfirstapplication

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking { // Thread: main
        // this: CoroutineScope instance
        // coroutineContext: CoroutineContext instance

        /* Without Parameter: CONFINED      [CONFINED DISPATCHER]
            - Inherits CoroutineContext from immediate parent coroutine.
            - Even after delay() or suspending function, it continues to run in the same thread.  */
        launch {
            println(this@runBlocking.coroutineContext)
            println("C1: ${Thread.currentThread().name}")       // Thread: main
            delay(1000)
            println("C1 after delay: ${Thread.currentThread().name}")   // Thread: main
        }
    }
}