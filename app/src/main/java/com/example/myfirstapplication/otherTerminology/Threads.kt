package com.example.myfirstapplication.otherTerminology

import kotlin.concurrent.thread

// Link: https://www.baeldung.com/kotlin/threads-coroutines

// Simple thread, inheriting class Thread and calling its constructor
class SimpleThread : Thread() {
    override fun run() {
        println("Before : ${currentThread()} is executing")
        sleep(1000)
        println("After : ${currentThread()} is executing")
    }
}

// Working with runnable, implementing runnable interface
class SimpleRunnable : Runnable {
    override fun run() {
        println("Before : ${Thread.currentThread()} is executing")
        Thread.sleep(1000)
        println("After : ${Thread.currentThread()} is executing")
    }

}

fun main() {
    /*
        // Ex:1
        val simpleThread = SimpleThread()
        simpleThread.start()

        // Ex:2
        val simpleRunnable = SimpleRunnable()
        Thread(simpleRunnable).start()

        // Ex:3 Rather than Ex:2 using this anonymous class concept
        val anonymousRunnable = object : Runnable {
            override fun run() {
                println("Inside Anonymous runnable with thread ${Thread.currentThread()}")
            }
        }
        Thread(anonymousRunnable).start()

        // Ex:4 Rather than Ex:3 use this type of lambda runnable. Ex:2:3:4 are same
        val lambdaRunnable =
            Runnable { println("Inside lambda runnable with thread ${Thread.currentThread()}") }
        Thread(lambdaRunnable).start()

        // Ex:5 Doing directly using lambda
        val thread = Thread {
            println("${Thread.currentThread()} has run.")
        }
        thread.start()

    //Ex:6 This Thread fun is provided by kotlin, above all are java
    // Priority-Threads with higher priorities are scheduled to run before threads with lower priorities.
    thread(start = true, name = "SagarThread1", priority = Thread.MAX_PRIORITY, isDaemon = true) {
        println("${Thread.currentThread()} started")
        Thread.sleep(1000)
        println("${Thread.currentThread()} Ended")
    }
    thread(start = true, name = "SagarThread2", priority = Thread.MIN_PRIORITY) {
        println("${Thread.currentThread()} started")
        Thread.sleep(1000)
        println("${Thread.currentThread()} Ended")
    }


    // Ex:7 Demon concept
    // isDemon-Daemon threads are background threads. When the main thread finishes its execution and all
    // non-daemon threads have also finished, the JVM terminates, regardless of whether daemon threads are still running.
    thread(true, priority = Thread.NORM_PRIORITY, isDaemon = true) {
        println("Inside Demon ${Thread.currentThread().name} ")
        while (true) {
            Thread.sleep(100)
            println("in Demon")
        }
    }
    println("Outside Demon start " + Thread.currentThread().name)
    Thread.sleep(1000) // Doing some work in main thread
    println("Outside Demon End ${Thread.currentThread().name}")
    // After 1 sec demon thread is still running but main thread work is done so its is ended
    // If you want that demon complete its work then, program terminates then use join()

    //Ex:8
    // See that before finishing background work program terminates, so to overcome this use
    // thread(isDeamon=true){}.join()
    thread(isDaemon = true) {
        println("background work started")
        Thread.sleep(2000)
        println("background work ended")
    }
    println("Main thread work started")
    Thread.sleep(1000)
    println("Main thread work ended")
*/
    // Ex:8
    // main thread and background thread, there both start at same time, by default thread is in main
    // program terminates after 1 sec and if background finishes before terminates it will be printed else not
    thread {
        println("Main Start")
        Thread.sleep(1000)
        println("Main End")
    }
    thread(isDaemon = true) {
        println("Background Start")
        Thread.sleep(500)
        println("Background End")
    }

    //Ex:9
    // You can make ct=0 then update it in background thread and print that in main diff thread
    var counter=0
    thread(true, name = "SagarThread", priority = Thread.MAX_PRIORITY, isDaemon = true) {
        println("Start")
        while (true){
            counter++
            Thread.sleep(200)
        }
    }
    thread {
        while (counter<100){
            println(counter)
            Thread.sleep(400)
        }
    }
}
