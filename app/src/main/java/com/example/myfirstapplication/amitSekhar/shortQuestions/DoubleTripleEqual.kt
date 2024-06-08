package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Structural Equality(==): It checks for equals()
Referential Equality(===): It checks whether two references point to same object
 */

internal class CarsOne(var color: String)

/*fun main() {
    val car1 = CarsOne("RED")
    val car2 = CarsOne("BLUE")
    val car3 = CarsOne("RED")

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
}