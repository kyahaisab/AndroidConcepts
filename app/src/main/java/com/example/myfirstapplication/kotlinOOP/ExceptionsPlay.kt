package com.example.myfirstapplication.kotlinOOP


// Writing custom exceptions
class IllegalAgeException(message: String) : Exception(message)

fun voterDetails(name: String, age: Int) {
    if (age < 18) throw IllegalAgeException("Age is less than 18")
    println("$name vote is casted")
}

fun main() {
    try {
        // Inside try program will not crash, try putting it outside try
        voterDetails("Sagar", 12)
    }
    // If not sure which exception to catch, just use e:Exception
    catch (e: Exception) {
        println(e.message)
        println(e.stackTrace)
    }

    try {
        println("Hello1")
        // Note lines above exception will be executed, but not below ones
        val res = 4 / 0
        println("Hello2")
    }
    // Inside catch put exception class you want to catch
    catch (e: ArithmeticException) {
        println(e.message)
    }
    // This will execute, in the end either there is error or not
    finally {

    }

    val a = 20
    val b = 0
    val ans = try {
        println("Inside Try")
        // below is returned
        a / b
    } catch (e: ArithmeticException) {
        println("Inside catch")
        //last line is return
        0
    }
    println(ans)
}