package com.example.myfirstapplication.kotlinOOP

// Everything inside enum is object
enum class Color {
    RED,
    BLUE,
    GREEN
}

interface ShowRespect {
    fun respect()
}

// Only interface can be inherited
enum class Caste(val nameCaste: String, val status: String) : ShowRespect {
    SHUDRA("OBC", "HIGH") {
        override fun respect() {
            println("Dravidians native indians")
        }
    },
    VAISHYA("GENERAL", "LOW") {
        override fun respect() {
            println("Baniyas")
        }
    },
    BRAMHAN("GENERAL", "LOWEST") {
        override fun respect() {
            println("Aryans Invasion")
        }
    }
}

fun main() {
    for (i in Color.entries) {
        println(i)
    }
    val color = Color.GREEN
    when (color) {
        Color.GREEN -> println(Color.GREEN)
        Color.BLUE -> println(Color.BLUE)
        Color.RED -> println(Color.RED)
    }

    println(Caste.SHUDRA)
    println(Caste.VAISHYA.nameCaste)
    Caste.BRAMHAN.respect()
}