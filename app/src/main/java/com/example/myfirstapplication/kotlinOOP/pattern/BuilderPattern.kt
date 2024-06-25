package com.example.myfirstapplication.kotlinOOP.pattern

/*
The Builder Pattern is a creational design pattern that allows for the creation of complex objects
 in a step-by-step manner. This pattern is particularly useful when an object needs to be
 constructed with many optional parameters or when the object construction process involves
 multiple steps. Ex  AlertDialogs, Notification objects.
 */

data class PhoneUser(
    val firstName: String?,
    val lastName: String?,
    val age: Int?,
    val address: String?
)

class PhoneUserBuilder {
    private var firstName: String? = null
    private var lastName: String? = null
    private var age: Int? = null
    private var address: String? = null

    fun setFirstName(firstName: String) = apply { this.firstName = firstName }
    fun setLastName(lastName: String) = apply { this.lastName = lastName }
    fun setAge(age: Int) = apply { this.age = age }
    fun setAddress(address: String) = apply { this.address = address }

    fun build() = PhoneUser(firstName, lastName, age, address)
}

fun main() {
    val user = PhoneUserBuilder()
        .setFirstName("John")
        .setLastName("Doe")
        .setAge(30)
        .setAddress("123 Main Street Quarters")
        .build()

    println(user)
}

// ********************** Example in real life *********************

/*
Advantages:
-Improves Readability: The code becomes more readable and maintainable, especially when dealing with
 objects that have many parameters.
-Avoids Constructor Overloading: It helps avoid the need for multiple constructors to handle
 different combinations of parameters.

fun showAlert(){
    val alertDialog = AlertDialog.Builder(this)
        .setTitle("Title")
        .setMessage("This is a message.")
        .setPositiveButton("OK") { dialog, which ->
            // Do something
        }
        .setNegativeButton("Cancel") { dialog, which ->
            // Do something
        }
        .create()

    alertDialog.show()
}*/
