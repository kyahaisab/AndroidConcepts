package com.example.myfirstapplication.practiveCode

import kotlin.concurrent.thread

fun generateNumbers(range: IntRange, times: Int, callback: (Int) -> Unit) {
    for (i in 0..times) {
        val randomValue = range.random()
        callback(randomValue)
    }
}

fun getNumberFromServer(a: Int, callback: (Int) -> Unit): String {
    thread {
        Thread.sleep(1000)
        callback(2332222)
    }
    return "Successful $a"
}

fun getNumServer(a: Int, callback: ((Int) -> Unit)? = null): String {
    thread {
        Thread.sleep(1000)
        callback?.invoke(a * a * 100)
    }
    return "Mission Done"
}

fun calculate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

/*
* inline in Kotlin, it tells the compiler to copy the function's code directly into the places where it's called
* instead of making a separate function call. This can make your code run faster because it skips the overhead
* of function calls.
So, if you have a small function that you use in many places, marking it with inline can improve performance.
* However, keep in mind that using inline too much can make your code larger, so it's best used for
* smaller functions or in situations where performance is critical.
* */
inline fun <T> calculateAns(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main(args: Array<String>) {

    // Way to define lambda
    val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
    val sumLambda1: (Int, Int) -> Int = { x, y ->
        println("Hello")
        val a = 23
        a + x + y
    }

    val sumValue = calculate(2, 6, { x, y ->
        x + y
    })
    val sumValue1 = calculate(2, 6) { x, y ->
        x + y
    }
    val sumValue3 = calculate(3, 6, sumLambda)
    val sumValue4 = calculate(3, 6, sumLambda1)

    println("sumvalue 1 2 3 4: $sumValue and $sumValue1 and $sumValue3 and $sumValue4")


    /* generateNumbers(0..10, 5){
         println(it)
     }

     val funVal=getNumberFromServer(12){
         println(it)
     }
     println("FUN Val: $funVal")

     println(getNumServer(56){
         println(it)
     })*/

    val inlineUse = calculateAns(3, 5) { x, y ->
        x * y
    }
    println(inlineUse)
}