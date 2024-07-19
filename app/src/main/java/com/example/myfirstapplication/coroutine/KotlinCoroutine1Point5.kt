package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // RB1: First this runBlocking will execute(as this blocks the curr thread) and then other one after this
    runBlocking {
        launch {
            println("Fake work start: ${Thread.currentThread().name} 1")
            delay(1000) // execution will stop and start again after 1000ms
            println("Fake work completed: ${Thread.currentThread().name} 2")
            delay(200) // execution will stop and start again after 200ms
            println("After other delay 3")
        }
        println("run blocking ends 4")
    }
    // RB2: After RB1 this one will execute
    runBlocking {
        delay(200)
        println("Another run blocking 5")
    }
    // Then finally this one
    println("out from run blocking 6")
}