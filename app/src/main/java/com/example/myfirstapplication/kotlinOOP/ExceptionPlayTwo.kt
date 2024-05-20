package com.example.myfirstapplication.kotlinOOP

class InvalidAgeException(message: String) : Exception(message)

fun validateAge(age: Int) {
    if (age < 0 || age > 150) {
        throw InvalidAgeException("Invalid age: $age. Age must be between 0 and 150.")
    }
}

fun getUserAge(input: String) {
    try {
        val age = input.toInt()
        validateAge(age)
        println("Valid age: $age")
    } catch (e: NumberFormatException) {
        println("Invalid input: '$input'. Please enter a valid number.")
    } catch (e: InvalidAgeException) {
        println(e.message)
    }
}

fun main() {
    val inputs = listOf("25", "-5", "200", "abc")

    for (input in inputs) {
        getUserAge(input)
    }
}
