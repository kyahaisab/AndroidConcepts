package com.example.myfirstapplication

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
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

