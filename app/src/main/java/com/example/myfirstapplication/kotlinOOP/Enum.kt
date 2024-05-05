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
// Only interce can be inherited
enum class Caste(val nameCaste: String, val status: String) : ShowRespect {
    SHUDRA("OBC", "HIGH") {
        override fun respect() {
            println("Ohh GOD")
        }
    },
    VAISHYA("GENERAL", "LOW") {
        override fun respect() {
            println("Bloody Baniya")
        }
    },
    BRAMHAN("GENERAL", "LOWEST") {
        override fun respect() {
            println("Chor")
        }
    }
}

fun main() {
    for (i in Color.values()) {
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