package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        println("Main program start: ${Thread.currentThread().name}")

        // There we are not consuming taskOne and taskTwo anywhere, so its better to lazy, without LAZY, both fun have executed
        // try removing : (start = CoroutineStart.LAZY) and see result.
        // So if functions are not used, they will not be executed
        val time = measureTimeMillis {
            val taskOne: Deferred<String> =
                async(start = CoroutineStart.LAZY) { taskOne() } // run in other background coroutine c1
            val tasKTwo: Deferred<String> =
                async(start = CoroutineStart.LAZY) { taskTwo() } // run in other background coroutine c2

            println("Result is: ${taskOne.await() + tasKTwo.await()}") // it will take 2023 millis if this line is exe, else 30 millis, if we do not use this lazy, then
            // it will take 1023 sec only
        }
        println("Time taken: $time")

        println("Main program Completed: ${Thread.currentThread().name}")
    }
}

private suspend fun taskOne(): String {
    delay(1000)
    println("Task one ended")
    return "Hello"
}

private suspend fun taskTwo(): String {
    delay(1000)
    println("Task two ended")
    return "World"
}
