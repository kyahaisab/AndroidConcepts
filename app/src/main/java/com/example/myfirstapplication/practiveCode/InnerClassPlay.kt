package com.example.myfirstapplication.practiveCode

class Animal(val color: String, val age: Int) {
    // This class is not able to access color and age of animal class
    class Tiger {
        fun animalName() {
            println("Its tiger")
        }
    }

    // To access Animal variables, use inner class to tell its inside some class
    inner class Zebra {
        fun animalName() {
            println("Its Zebra $color $age")
        }
    }
}

fun main() {

    val tiger = Animal.Tiger()
    tiger.animalName()

    val zebra = Animal("Black", 12).Zebra()
    zebra.animalName()
}