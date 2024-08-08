package com.example.myfirstapplication.kotlinOOP

open class DogRamu(val dogName: String) {
    open fun bark(): Int {
        println("Bhau Bhau Bhau")
        return 1
    }
}

// One cannot have instance of abstract class
abstract class BasicMachine(private var name: String) : DogRamu("Ramu") {
    abstract var brand: String
    abstract fun makeCoffee(): String
    val barkNoise = bark()
    fun coffeeDetails(): String {
        return "Machine name is $name"
    }

    open fun makingTime() {
        println("@0 mins only")
    }

    override fun bark(): Int {
        return 100
    }
}

class DesiCoffee(private val nameBrand: String) : BasicMachine(nameBrand) {
    override var brand: String
        get() = "MODE"
        set(value) {}

    val coffeeDetail = coffeeDetails()
    override fun makeCoffee(): String {
        return "Done making coffee"
    }

    // You cannot override coffeeDetails as it is not open
    override fun makingTime() {
        super.makingTime()
        println("30min as in Desi machine")
    }
}

fun main() {
    val coffee = DesiCoffee("cool brand")
    println(coffee.brand)
    coffee.makingTime()
}