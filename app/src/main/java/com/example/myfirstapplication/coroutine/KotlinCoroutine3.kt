package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
 Coroutine builders:
 Coroutine builders are used for creating co routines. 3 types of builders- launch, async, runBlocking, other ways as well
 So the diff b/w launch and GlobalScope.launch ex. say we are on login screen from there we move to signup screen and there we
 used launch coroutine c1 on returning from sign up screen c1 will get automatically cancelled(c1 was created in local scope of signup,
 so when signup destroyed). If we have used GlobalScope.launch rather than launch it would have existed for lifetime of app.
 When to use:
 launch -> File download, play music. Do not use them unless needed
 GlobalScope.launch -> data computation, Login operation relevant to that screen only
 */

/*fun main() {
    runBlocking { // will run on current thread i.e main thread
        println("Main program starts: ${Thread.currentThread().name}") // main thread

        // launch co routine will inherit thread and score of immediate parent coroutine
        launch {
            println("Fake work start: ${Thread.currentThread().name}")// main
            delay(1000) // Coroutine is suspended but Thread: main is free
            println("Fake work completed: ${Thread.currentThread().name}") // Either main thread of some other thread
        }

        delay(1500)

        println("Main program Ended: ${Thread.currentThread().name}") // main
    }
}*/
/*

fun main() {
    runBlocking { // will run on current thread i.e main thread
        println("Main program starts: ${Thread.currentThread().name}") // main thread

        // launch co routine will inherit thread and score of immediate parent coroutine, and it does not block the curr thread
        // launch returns job object
        val job: Job = launch {
            println("Fake work start: ${Thread.currentThread().name}")// main
            delay(1000) // Coroutine is suspended but Thread: main is free
            println("Fake work completed: ${Thread.currentThread().name}") // Either main thread of some other thread
        }
        // Rather than using delay use job.join() to get same result, but this is a good way than delay
        job.join() // will wait for this job to be finished then only next statement is executed
        // to cancel job use job.cancel()

        println("Main program Ended: ${Thread.currentThread().name}") // main
    }
}
*/

fun main() {
    runBlocking { // will run on current thread i.e main thread
        println("Main program starts: ${Thread.currentThread().name}") // main thread

        // async co routine will inherit thread and score of immediate parent coroutine, and it does not block the curr thread
        // launch returns deferred object
        val jobDeferred: Deferred<String> =
            async { // one can use GlobalScope.async have global scope
                println("Fake work start: ${Thread.currentThread().name}")// main
                delay(1000) // Coroutine is suspended but Thread: main is free
                println("Fake work completed: ${Thread.currentThread().name}") // Either main thread of some other thread
                // below you can write 12, "Sagar", etc
                "sagar"
            }

        //jobDeferred.join() // will wait for this job to be finished then only next statement is executed
        // If you want to get the value in jobDeferred, one can use cancel() to cancel this deferred obj coroutine
        val value = jobDeferred.await()
        println("Result value: $value")

        println("Main program Ended: ${Thread.currentThread().name}") // main
    }
}

// Used for testing purpose
suspend fun mySuspendFunction() {
    delay(1000)
}
