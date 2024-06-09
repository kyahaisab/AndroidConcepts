package com.example.myfirstapplication.kotlinOOP

// all classes in kotlin re final by default, so if you want to inherit this class make it open
open class BaseCoffeeMachine(
    private val price:String,
    private val color:String
){
    fun makeCoffee(){
        println("Your coffee is ready in $price with color $color")
    }
}

class PremiumCoffeeMachine(
    private val price:String,
    private val color:String
): BaseCoffeeMachine(price, color){
    fun makeCapchino(){
        println("Here is capchino")
    }
}


fun main(){
    val coffeeMachine=BaseCoffeeMachine("10000", "RED")
    coffeeMachine.makeCoffee()

    val premium=PremiumCoffeeMachine("1200", "PINK")
    premium.makeCapchino()
    premium.makeCoffee()
}