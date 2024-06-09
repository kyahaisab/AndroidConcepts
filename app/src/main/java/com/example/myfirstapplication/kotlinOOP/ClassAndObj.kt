package com.example.myfirstapplication.kotlinOOP

// General convention is to name class with Capital letters
// Though it seems like kotlin access values directly without getters and setters, but in reality it creates and use
// them inside
class Box {
    var length: Int = 4
    var breadth: Int = 9
    var height: Int = 10

    // We can create our custom getter and setter
    var x: Int? = 0
        get() = 10
        set(value) {
            field = value // field refers to x
        }

    val volume: Int
        get() = breadth * length * height
    /*set(value) {
        // We cannot have setter as its val
    }*/

    var boxName: String = "Box Name"
        set(value) {
            if (value.length < 3) {
                println("Name can't be less than 3 characters")
            } else {
                field = value
                println("Box name is set")
            }
        }

    fun openBox() {
        println("Box is opened")
    }

    fun closeBox() {
        println("Box is closed")
    }
}

fun main() {
    val box = Box()

    box.length = 23
    println(box.length)
    println(box.breadth)

    box.openBox()
    box.closeBox()

    println(box.volume)
    box.boxName = "ab"
}