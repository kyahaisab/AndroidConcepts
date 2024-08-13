package com.example.myfirstapplication.kotlinOOP.definedFunctions

fun main() {
    // 1. length: Returns the length of the string.
    val text = "Hello, Kotlin!"
    println(text.length) // Output: 13

    // 2. uppercase / lowercase: Converts all characters in the string to uppercase or lowercase.
    println(text.uppercase()) // Output: HELLO, KOTLIN!
    println(text.lowercase()) // Output: hello, kotlin!

    // 3. substring: Extracts a substring from the string, given a start and end index.
    val sub = text.substring(7, 13)
    println(sub) // Output: Kotlin

    // 4. replace: Replaces occurrences of a substring with another string.
    val replaced = text.replace("World", "Kotlin")
    println(replaced) // Output: Hello, Kotlin!

    // 5. contains: Checks if the string contains a specific substring.
    println(text.contains("Kotlin")) // Output: true

    // 6. split: Splits the string into a list of substrings based on a delimiter.
    val words = text.split(" ")
    println(words) // Output: [Hello,, Kotlin!]

    // 7. trim: Removes leading and trailing whitespace from the string.
    val trimmed = "   Kotlin   ".trim()
    println(trimmed) // Output: Kotlin

    // 8. startsWith / endsWith: Checks if the string starts or ends with a specific substring.
    println(text.startsWith("Hello")) // Output: true
    println(text.endsWith("Kotlin!")) // Output: true

    // 9. indexOf: Returns the index of the first occurrence of a substring, or -1 if not found.
    val index = text.indexOf("Kotlin")
    println(index) // Output: 7

    // 10. isEmpty / isBlank: Checks if the string is empty or consists only of whitespace characters.
    val emptyText = ""
    val blankText = "   "
    println(emptyText.isEmpty()) // Output: true
    println(blankText.isBlank()) // Output: true

    // 11. toInt / toDouble / toFloat: Converts a string to a number type (Int, Double, Float).
    // Throws an exception if the string is not a valid number.
    val numberString = "123"
    val number = numberString.toInt()
    println(number) // Output: 123

    // 12. reversed: Returns a new string with the characters in reverse order.
    val reversed = text.reversed()
    println(reversed) // Output: !niltoK ,olleH

    // 13. capitalize / decapitalize: Capitalizes or decapitalizes the first character of the string.
    val word = "kotlin"
    println(word.capitalize()) // Output: Kotlin
    println(word.decapitalize()) // Output: kotlin

    // 14. format: Formats a string using placeholders and arguments.
    val name = "Kotlin"
    val formattedText = "Hello, %s!".format(name)
    println(formattedText) // Output: Hello, Kotlin!

    // 15. take / drop: Takes or drops the first n characters of a string.
    val firstFive = text.take(5)
    val withoutFirstFive = text.drop(5)
    println(firstFive) // Output: Hello
    println(withoutFirstFive) // Output: , Kotlin!
}
