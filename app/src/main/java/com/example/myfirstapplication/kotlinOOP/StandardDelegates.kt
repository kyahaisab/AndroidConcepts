package com.example.myfirstapplication.kotlinOOP

import kotlin.properties.Delegates

class HeavyProcessingAPI {
    init {
        println("Heavy class initialized")
    }
}

class StudentResult {
    val heavy = HeavyProcessingAPI()
}


class StudentResultSmooth {
    // Using lazy initialization, meaning HeavyProcessingAPI() will be instansiated only when it is accessed
    val heavy by lazy {
        HeavyProcessingAPI()
    }
    // Another delegate
    var marks by Delegates.observable(20) { _, oldValue, newValue ->
        println("Old value and new value: $oldValue and $newValue")
    }
    // Another delegate
    var age by Delegates.vetoable(22){property, oldValue, newValue ->
        println("Old age and new age: $oldValue and $newValue")
        // Below is the condition to be true to set the value
        newValue>=18
    }
}


fun main() {
    //val student =StudentResult() // init called

    val smoothStudent = StudentResultSmooth()// init will not be called
    smoothStudent.heavy// now it is accessed, so it will be called

    smoothStudent.marks=29
    smoothStudent.age=12 // see old value
    println(smoothStudent.age)// value is still 22
    smoothStudent.age=11 // see old value, assignement is not done as condition is not true
}