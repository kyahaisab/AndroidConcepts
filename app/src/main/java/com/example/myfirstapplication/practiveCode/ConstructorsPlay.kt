package com.example.myfirstapplication.practiveCode

// This is primary constructor it can be private as well-> put private before constructor
// If you are not giving any visibility then you can write class BoxPlay(...) simply
// In java we pass values to constructor then those values are assigned to class variables, here boilerplate code
// is removed.
class BoxPlay constructor(
    var length: Int = 21,
    var breadth: Int = 23,
    var height: Int = 43
) {
    // Just after primary constructor, if you want to do something, as in P constructor you are not allowed to write logic
    init {
        println("Inside Init block")
    }

    // This is secondary constructor, this->is primary constructor
    constructor(defaultValue: Int) : this(defaultValue, defaultValue, 3){
        println("Secondary constructor")
    }

    val volume: Int
        get() = length * breadth * height
}

fun main() {
    val box = BoxPlay(7)
    println(box.volume)

    val box1 = BoxPlay(9, 9, 9)
    println(box1.volume)
}