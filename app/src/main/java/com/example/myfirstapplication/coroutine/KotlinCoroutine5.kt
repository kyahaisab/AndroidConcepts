package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/*

fun main() {
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")

        // Its a coroutine builder same as launch, async, etc. It will cancel the coroutine in 2 sec if it is not completed
        withTimeout(2000) {
            try {
                for (i in 0..300) {
                    println("$i.")
                    delay(100)
                }
            } catch (e: TimeoutCancellationException) {
                // ...
            } finally {
                // ...
            }
        }
        // You can put withTimeout inside try block to get uninterrupted result

        println("Main program Ended: ${Thread.currentThread().name}")
    }
}*/

fun main() {
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")

        // Its a coroutine builder same as launch, async, etc. It will cancel the coroutine in 2 sec if it is not completed
        // It will not through error and you can return value from this block, if its timeout you will get null
        val result: String? = withTimeoutOrNull(2000) {
            for (i in 0..300) {
                println("$i.")
                delay(100)
            }
            // You can return anything like 14, "Hello", etc
            "Hello Moto"
        }
        println("Return value: $result")
        println("Main program Ended: ${Thread.currentThread().name}")
    }
}