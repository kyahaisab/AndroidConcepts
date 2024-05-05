package com.example.myfirstapplication.kotlinOOP

// In java we have POJO classes, that are designed to store data only with getter and setters
// In kotlin its simplified
data class PersonDetail(
    var name: String,
    var age: Int,
    var race: String
) {
    // You can have body of data class as well if required
    fun getFullDetail(): String {
        return "$name $age $race"
    }
}

fun main() {
    val person = PersonDetail("Sagar", 25, "Asian")
    println(person)
    println(person.toString())
    println(person.getFullDetail())
}