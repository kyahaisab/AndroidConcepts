package com.example.myfirstapplication.otherTerminology


// Thread join usage
// join() method wait for a thread to finish its execution before continuing with the current thread.

fun main() {
    val thread1 = Thread {
        repeat(5) {
            println("Thread 1: $it")
            Thread.sleep(100) // Simulate some work
        }
    }

    val thread2 = Thread {
        repeat(5) {
            println("Thread 2: $it")
            Thread.sleep(100) // Simulate some work
        }
    }

    // both will start simultaneously, they can be printed in any order.
    // if you want to make then run sequential i.e. Thread1 then thread2 then simple use
    // thread1.join() after thread1.start()
    thread1.start()
    thread2.start()
}

/*
fun main() {
    // To demonstrate that t1.join will block program until t1 is finished
    println("Outside threads st")

    val t1 = thread(isDaemon = true) {
        println("Inside demon st")
        Thread.sleep(2000)
        println("Inside demon end")
    }
    val t2 = thread {
        println("Inside thread st")
        Thread.sleep(1000)
        println("Inside thread end")
    }

    println("Outside threads end1")
    t1.join()
    println("Outside threads end2")
}
*/
