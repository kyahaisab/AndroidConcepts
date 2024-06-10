package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Structural Equality(==): It checks for equals(), meaning it compares the contents of two objects to see if they are equivalent.
Referential Equality(===): It checks whether two references point to same object
 */

internal class CarsOne(var color: String)

/*fun main() {
    val car1 = CarsOne("RED")
    val car2 = CarsOne("BLUE")
    val car3 = CarsOne("RED")

    val a = "Kotlin"
    val b = "Kotlin"
    println(a == b)

    println(car1 == car2)
    println(car1 == car3)

    println(car1===car3) // false: as reference to both the object is diff

    val car4=car3
    println(car4===car3) // true as reference to both objects are same now
}*/

/*
Two ways to implement equals method
-Making the class a data class
-Adding our own equals() method implementation
 */

internal data class CarsTwo(val color: String)

fun main() {
    val car1 = CarsTwo("RED")
    val car2 = CarsTwo("BLUE")
    val car3 = CarsTwo("RED")

    println(car1 == car2)
    println(car1 == car3)

    println(car1 === car3) // false: as reference to both the object is diff
    val car4 = car3
    println(car4 === car3) // true as reference to both objects are same now

    val a = "Kotlin"
    val b = "Kotlin"
    val c = a
    println(a === b)  // Output: false
    println(a === c)  // Output: true
}