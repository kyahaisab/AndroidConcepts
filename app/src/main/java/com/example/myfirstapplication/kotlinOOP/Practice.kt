package com.example.myfirstapplication.kotlinOOP

import kotlin.concurrent.thread

// Using inheritance, calling constructors
class PracticeThreads : Thread() {
    override fun run() {
        println("Thread Start")
        sleep(1000)
        println("Thread End")
    }
}

// Using Runnable
class PracticeRunnable : Runnable {
    override fun run() {
        println("Thread Start")
        Thread.sleep(1000)
        println("Thread End")
    }

}

fun main() {
//    val practiceThreads=PracticeThreads()
//    practiceThreads.start()

//    val practiceRunnable = PracticeRunnable()
//    Thread(practiceRunnable).start()

//    val runnable = Runnable { println("Hello Boy") }
//    runnable.run { Thread(this).start() }

//    thread(false) { println("Hello") }.start()

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
