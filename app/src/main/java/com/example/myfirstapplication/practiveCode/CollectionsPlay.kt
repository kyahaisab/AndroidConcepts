package com.example.myfirstapplication.practiveCode

/* *
+------+--------------+---------------------+
|      |  Immutable   |       Mutable       |
+------+--------------+---------------------+
| List | listOf<T>()  | mutableListOf<T>()  |
| Set  | setOf<T>()   | mutableSetOf<T>()  |
| Map  | mapOf<K,V>() | mutableMapOf<K,V>() |
+------+--------------+---------------------+
* */
fun main() {
    val movies = listOf<String>("Kala", "Dhoom", "Hai ho")
    for (i in movies.indices) {
        println(movies[i])
    }

    val ratings = mutableListOf<Int>(2, 4, 1, 6, 7, 2)
    ratings.removeAt(ratings.size - 1)
    ratings.add(23)

    for (i in ratings.indices) {
        println(ratings[i])
    }
}