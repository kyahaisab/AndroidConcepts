package com.example.myfirstapplication.kotlinOOP

// In java we have POJO classes, that are designed to store data only with getter and setters
// In kotlin its simplified

open class Detail {
    open fun giveInfo() {
        println("Hello")
    }
}

// Can Inherit classes as well, but not data class
data class PersonDetail(
    var name: String,
    var age: Int,
    var race: String
) : Detail() {
    // You can have body of data class as well if required
    fun getFullDetail(): String {
        return "$name $age $race"
    }

    override fun giveInfo() {

    }
}

fun main() {
    val person = PersonDetail("Sagar", 25, "Asian")
    println(person)
    println(person.toString())
    println(person.getFullDetail())
}