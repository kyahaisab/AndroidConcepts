package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*

// Every coroutine has its own CoroutineScope instance attached to it.
fun main() {
    runBlocking {
        println(this)

        launch {
            println(this)
        }

        async {
            println(this)
        }
        println("Some other code ....")
    }
}*/

// Coroutine context - it has 2 major objects namely dispatcher and job
// It is the Dispatcher which decides on which thread the coroutine will execute.
fun main() {
    runBlocking { // Thread: main
        // this: CoroutineScope instance
        // coroutineContext: CoroutineContext instance

        /* Without Parameter: CONFINED      [CONFINED DISPATCHER]
            - Inherits CoroutineContext from immediate parent coroutine.
            - Even after delay() or suspending function, it continues to run in the same thread.  */
        launch {
            println("C1: ${Thread.currentThread().name}")       // Thread: main
            delay(1000)
            println("C1 after delay: ${Thread.currentThread().name}")   // Thread: main
        }

        /* With parameter: Dispatchers.Default [similar to GlobalScope.launch { } ]
            - Gets its own context at Global level. Executes in a separate background thread.
            - After delay() or suspending function execution,
                it continues to run either in the same thread or some other thread.  */
        launch(Dispatchers.Default) {
            println("C2: ${Thread.currentThread().name}")   // Thread: T1
            delay(1000)
            println("C2 after delay: ${Thread.currentThread().name}")   // Thread: Either T1 or some other thread
        }

        /*  With parameter: Dispatchers.Unconfined      [UNCONFINED DISPATCHER]
            - Inherits CoroutineContext from the immediate parent coroutine.
            - After delay() or suspending function execution, it continues to run in some other thread.  */
        launch(Dispatchers.Unconfined) {
            println("C3: ${Thread.currentThread().name}")   // Thread: main
            delay(1000)
            println("C3 after delay: ${Thread.currentThread().name}")   // Thread: some other thread T1

            launch(coroutineContext) {
                println("C5: ${Thread.currentThread().name}")       // Thread: T1
                delay(1000)
                println("C5 after delay: ${Thread.currentThread().name}")   // Thread: T1
            }
        }

        // by writing coroutineContext we provide context of parent i.e main in our case, its like confined dispatcher
        launch(coroutineContext) {
            println("C4: ${Thread.currentThread().name}")       // Thread: main
            delay(1000)
            println("C4 after delay: ${Thread.currentThread().name}")   // Thread: main
        }

        println("...Main Program...")
        // Dispatcher id of 4 types-Main, IO, Default, Unconfined
    }
}
