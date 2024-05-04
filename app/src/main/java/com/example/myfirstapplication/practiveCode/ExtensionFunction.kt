package com.example.myfirstapplication.practiveCode

data class Person(var name: String, var age: Int)

// We can modify classes we don't own
fun String.testFun(): String {
    return "Hello Extension $this"
}

fun main(args: Array<String>) {
    println("Ramu".testFun())
}