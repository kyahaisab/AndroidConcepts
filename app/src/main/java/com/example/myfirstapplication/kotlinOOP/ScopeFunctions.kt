package com.example.myfirstapplication.kotlinOOP

/*
Kotlin Scope Functions
+----------+----------------+----------------+
| Function | Context Object |  Return Value  |
+----------+----------------+----------------+
| let      | it             | lambda result  |
| run      | this           | lambda result  |
| with     | this           | lambda result  |
| apply    | this           | context object |
| also     | it             | context object |
+----------+----------------+----------------+
*/

class Square(
    var length: Int, var width: Int, var name: String, var color: String
) {
    fun fillColor(color: String) {
        this.color = color
        println("$color is filled")
    }

    fun addText(text: String) {
        this.name = text
        println("Text added is: $name")
    }
}

private lateinit var square: Square
fun main() {
    // **** let: context object --> it and return value lambda(can be it, string, anything)
    val sq = Square(12, 15, "CPX", "RED").let {
        it.fillColor("PINK")
        it.addText("RDX BOX")
        // Below can be anything, it, string, Unit, integer, etc and that will store in sq
        //"Hello World"
        null
    }
    println(sq)

    sq?.let { square = it } // Using null safety

/*                         -----------------IMPORTANT---------------
****************************************************************************************************
    val sqr1 = Square(11, 19, "9XPX", "Blood").let {                                               *
        it.width = 22                                                                              *
        // Below, if any assignment or some print statements then Unit will be returned            *
        // eg. it.name = "Kal" or println("LoP"), etc then unit will be assigned to sqr1           *
        println("Hello Nothing")                                                                   *
    }                                                                                              *
    println(sqr1)                                                                                  *
                                                                                                   *
    // Case: when we use null safety and we want some default initialisation                       *
    val squareObject: Square? = null                                                               *
    val sqr2 = squareObject?.let {                                                                 *
        it.width = 23                                                                              *
    } ?: "BIG DAWGS"                                                                               *
    println(sqr2)                                                                                  *
****************************************************************************************************
*/
    // *** run:
    val sq1 = Square(13, 19, "Cube", "Maroon").run {
        this.fillColor("ORANGE")
        addText("CUBOID")
        // Return :Below can be anything, it, string, Unit, integer, etc and that will store in sq
        this
    }
    println(sq1)
    sq1?.run { square = this }

    // *** With:
    val sq2 = Square(23, 18, "MAX", "BLUE")
    val result = with(sq2) {
        addText("Hello")
        this.fillColor("Purple")
        // Return lambda: anything
        "Some value"
    }
    println(result)

    // *** Apply
    val sq3 = Square(28, 32, "LAM", "LIPN").apply {
        addText("LION")
        length = 99
        // Return type is context object by default
    }
    println(sq3)

    // *** Also
    val sq4 = Square(28, 32, "LAM", "LIPN").also {
        it.fillColor("BOOM BLACK")
        // Return type is context object by default
    }
    println(sq4)
}