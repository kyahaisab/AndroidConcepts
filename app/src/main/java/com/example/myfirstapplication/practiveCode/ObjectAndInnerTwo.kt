package com.example.myfirstapplication.practiveCode

import java.util.Objects

interface Vehicle {
    fun onCarStarted(name: String)
    fun onCarRunning(speed: Int)
}

open class Bag {
    open fun handBag(size:Int) {
        println("HandBag")
    }
}

fun main() {
    val vehicle = object : Vehicle {
        override fun onCarStarted(name: String) {
            println(name)
        }

        override fun onCarRunning(speed: Int) {
            println("$speed")
        }
    }
    vehicle.onCarRunning(23)


    // Dealing with class
    val bag = object : Bag() {
        override fun handBag(size: Int) {
            super.handBag(size)
            println("Modified handbag $size")
        }
    }
    bag.handBag(23)
}