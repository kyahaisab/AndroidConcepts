package com.example.myfirstapplication.kotlinOOP

// One canot have instance of abstract class
abstract class BasicMachine(private var name: String){
    abstract var brand:String

    abstract fun makeCoffee():String

    fun coffeeDetails(): String{
        return "Machine name is $name"
    }

    open fun makingTime(){
        println("@0 mins only")
    }
}

class DesiCoffee(private val nameBrand: String):BasicMachine(nameBrand){
    override var brand: String
        get() = "MODE"
        set(value) {}

    override fun makeCoffee(): String {
       return "Done making coffee"
    }

    // You cannot ovverdide coffeeDetails as it is not open
    override fun makingTime() {
        super.makingTime()
        println("30min as in Desi machine")
    }
}

fun main(){
    val coffee=DesiCoffee("cool brand")
    println(coffee.brand)
    coffee.makingTime()
}