package com.example.myfirstapplication.kotlinOOP.definedFunctions

fun main() {
    // 1. map: Transforms each element by applying the given function.
    val numbers = listOf(1, 2, 3, 4)
    val doubled = numbers.map { it * 2 }
    println(doubled) // Output: [2, 4, 6, 8]

    // 2. filter: Filters elements that match the given predicate.
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers) // Output: [2, 4]

    // 3. flatMap: Applies a function that returns a collection and flattens the result.
    val words = listOf("Hello", "World")
    val chars = words.flatMap { it.toList() }
    println(chars) // Output: ['H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd']

    // 4. reduce: Reduces the collection to a single value by applying a binary operation.
    val sum = numbers.reduce { acc, num -> acc + num }
    println(sum) // Output: 10

    // 5. fold: Similar to reduce, but with an initial accumulator value.
    val sumWithFold = numbers.fold(0) { acc, num -> acc + num }
    println(sumWithFold) // Output: 10

    // 6. forEach: Performs an action for each element in the collection.
    numbers.forEach { println(it) } // Output: 1 2 3 4

    // 7. find: Finds the first element that matches the given predicate.
    val result = numbers.find { it > 2 }
    println(result) // Output: 3

    // 8. first: Returns the first element that matches the predicate, or throws an exception.
    val firstResult = numbers.first { it > 2 }
    println(firstResult) // Output: 3

    // 9. groupBy: Groups elements by the key returned from the given function.
    val grouped = words.groupBy { it.length }
    println(grouped) // Output: {5=[Hello, World]}

    // 10. partition: Splits the collection into two lists based on a predicate.
    val (even, odd) = numbers.partition { it % 2 == 0 }
    println(even) // Output: [2, 4]
    println(odd) // Output: [1, 3]

    // 11. zip: Combines two collections into a list of pairs.
    val names = listOf("Alice", "Bob", "Charlie")
    val ages = listOf(25, 30, 35)
    val resultZip = names.zip(ages)
    println(resultZip) // Output: [(Alice, 25), (Bob, 30), (Charlie, 35)]

    // 12. distinct: Removes duplicate elements from the collection.
    val distinctNumbers = numbers.plus(2).distinct()
    println(distinctNumbers) // Output: [1, 2, 3, 4]

    // 13. sortedBy: Sorts the collection by the given selector function.
    val sortedWords = words.sortedBy { it.length }
    println(sortedWords) // Output: [Hello, World]

    // 14. take: Takes the first n elements from the collection.
    val firstTwo = numbers.take(2)
    println(firstTwo) // Output: [1, 2]

    // 15. drop: Drops the first n elements from the collection.
    val withoutFirstTwo = numbers.drop(2)
    println(withoutFirstTwo) // Output: [3, 4]
}
