package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// Sequential execution
/*fun main() {
    runBlocking {
        println("Main program start: ${Thread.currentThread().name}")

        val measureTime = measureTimeMillis {
            val taskOne = taskOne()
            val tasKTwo = taskTwo()
            println("Result is: ${taskOne + tasKTwo}")
        }
        //So here you can note one thing.Within a coroutine which in our case is runBlocking,
        // by default the methods are executed sequentially.
        // Line 10,then 12-15, then 20, then 22 sequentially
        println("Total time taken: $measureTime") // nearly 2 sec

        println("Main program Completed: ${Thread.currentThread().name}")
    }
}*/

private suspend fun taskOne(): String {
    delay(1000)
    return "Hello"
}

private suspend fun taskTwo(): String {
    delay(1000)
    return "World"
}

// Run parallel or concurrently, we can use launch, async, etc
/*fun main() {
    runBlocking {
        println("Main program start: ${Thread.currentThread().name}")

        val measureTime = measureTimeMillis {
            val taskOne: Deferred<String> =
                async { taskOne() } // run in other background coroutine c1
            val tasKTwo: Deferred<String> =
                async { taskTwo() } // run in other background coroutine c2
            println("Result is: ${taskOne.await() + tasKTwo.await()}")
        }
        /*
         - Await, join wait for result, taskOne and taskTwo launched and then waiting started, so 1 sec.
           line 45 launched 1 ms(internally working for 1 sec), line 47 launched 1 ms(internally working for 1 sec), then
           taskOne.await() wait for 1000ms to get result, then tasKTwo.await() wait for 1 ms so total 1000ms time
         - But is taskOne then await = wait for result 1 sec, then taskTwo and await then = 1 sec to wait for result then move ahead
          */
        println("Total time taken: $measureTime") // nearly 1 sec, means both runs concurrently

        println("Main program Completed: ${Thread.currentThread().name}")
    }
}*/
