package com.example.myfirstapplication.kotlinOOP

/* *      READ ONLY       READ AND WRITE
+------+--------------+---------------------+
|      |  Immutable   |       Mutable       |
+------+--------------+---------------------+
| List | listOf<T>()  | mutableListOf<T>()  |
| Set  | setOf<T>()   | mutableSetOf<T>()  |
| Map  | mapOf<K,V>() | mutableMapOf<K,V>() |
+------+--------------+---------------------+
* */


/*
// List:
fun main() {
    val movies = listOf<String>("Kala", "Dhoom", "Hai ho")
    for (i in movies.indices) {
        println(movies[i])
    }
    movies.forEach { println(it) }

    val ratings = mutableListOf<Int>(2, 4, 1, 6, 7, 2)
    ratings.removeAt(ratings.size - 1)
    ratings.add(23)

    for (i in ratings.indices) {
        println(ratings[i])
    }
}*/

/*
// Set
fun main() {
    val names = setOf("Ramu", "Babu", "Charlie", "Babu") // set will only store unique elements
    //names.forEach { println(it) }

    val names1 =
        mutableSetOf("Ramu", "Babu", "Charlie", "Babu") // set will only store unique elements
    names1.add("Leo")
    names1.remove("Ramu")
    names1.forEach { println(it) }
    println(names1.contains("Ramu"))
}*/


// MAP
fun main() {
    val datingPairs = mutableMapOf(1 to "Ramu", 2 to "Sindhi")
    datingPairs[3] = "Titu"
    println(datingPairs[1])
}
