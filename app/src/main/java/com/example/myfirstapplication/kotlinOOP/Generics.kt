package com.example.myfirstapplication.kotlinOOP

class ArrayUtils(private val array: Array<Int>) {
    fun findIndex(element: Int, callback: (index: Int, value: Int?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                callback(i, array[i])
                return
            }
        }
        callback(-1, null)
        return
    }
}

class ArrayUtils1<T>(private val array: Array<T>) {
    fun findIndex(element: T, callback: (index: Int, value: T?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                callback(i, array[i])
                return
            }
        }
        callback(-1, null)
        return
    }
}

// Instead of doint it at class leved do it in function level
fun <M> findIndexFun(array: Array<M>, element: M, callback: (index: Int, value: M?) -> Unit) {
    for (i in array.indices) {
        if (array[i] == element) {
            callback(i, array[i])
            return
        }
    }
    callback(-1, null)
    return
}


fun <T, M> M.findIndex(array: Array<T>, ele: T, callback: (T?, Int) -> Unit) {
    for (i in array.indices) {
        if (array[i] == ele) {
            callback(array[i], i)
            return
        }
    }
    println("We received generics: $this")
    callback(null, -1)
    return
}


fun main(args: Array<String>) {
    // Generics
    // 1. Normal, we canout find string values, its only for integers
    val array = ArrayUtils(arrayOf(1, 2, 3, 4, 5, 6))
    array.findIndex(9) { index, value ->
        println("Index and value is $index $value")
    }
    //2. Using generics problem is solved
    val arrayInt = ArrayUtils1<Int>(arrayOf(1, 2, 3, 4, 5, 6))
    arrayInt.findIndex(9) { index, value ->
        println("Index and value is $index $value")
    }
    val arrayString = ArrayUtils1<String>(arrayOf("1", "2", "4", "8", "Kajal"))
    arrayString.findIndex("Kajal") { index, value ->
        println("Index and value is $index $value")
    }
    // Independent of class
    findIndexFun<Int>(arrayOf(1, 2, 3, 4, 5, 6), 3) { index, value ->
        println("Function level Index and value is $index $value")
    }

    // Great amalagantion of generics, extension fun and lambda, no need to set generics type
    234.findIndex(arrayOf(2, 3, 4, 5, 56, 2, 17, 8), 12) { value, index ->
        println("value and Index: $value and $index")
    }
    // setting generics type
    "Hello World".findIndex<Int, String>(arrayOf(2, 3, 4, 5, 56, 2, 17, 8), 12) { value, index ->
        println("value and Index: $value and $index")
    }
}