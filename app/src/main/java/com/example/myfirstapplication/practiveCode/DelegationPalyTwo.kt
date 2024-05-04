package com.example.myfirstapplication.practiveCode

import androidx.compose.ui.text.toUpperCase
import kotlin.reflect.KProperty

// Why delegation is needed

class Student {
    // There we are repeating code of setter in variables
    var firstName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().uppercase()
            }
        }
    var lastName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().uppercase()
            }
        }

    // Now we will use delegates, replacing repeating setters
    var address: String? by NameDelegate()
    var phoneNumber: String? by NameDelegate()

    override fun toString(): String {
        return "$address $phoneNumber"
    }
}

// We are implementing custom delegation.
class NameDelegate {
    private var formattedValue: String? = null

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String?
    ) {
        if (value != null && value.length > 5)
            formattedValue = value.trim().uppercase()
    }

    operator fun getValue(
        student: Student,
        property: KProperty<*>
    ): String? {
        return formattedValue
    }
}

fun main() {
    val student = Student()
    student.address = "229H/2 Preetam Nagar, Allahabad, U.P, India"
    student.phoneNumber = "7355182778"

    println("${student.address} and ${student.phoneNumber}")
}