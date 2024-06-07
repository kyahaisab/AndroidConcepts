package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Reified Type Parameters
By default, type parameters of generic functions are erased at runtime. To retain the type information,
you can use the reified keyword with type parameters in an inline function. This allows you to perform
type-specific operations within the function. Reified is a keyword used in combination with inline functions
 */

// The type of T is retained at runtime, allowing us to get its name using T::class.java.simpleName.
inline fun <reified T> getTypeName(): String {
    return T::class.java.simpleName
}

inline fun <reified T> isInstanceOf(value: Any): Boolean {
    return value is T
}

fun main() {
    println(getTypeName<Int>())  // Output: Int
    println(getTypeName<String>())  // Output: String

    println(isInstanceOf<String>("Hello"))  // Output: true
    println(isInstanceOf<Int>("Hello"))  // Output: false
}

//**************************** More about retaining type info and not retaining it*****************
/*
Without reified Type Parameters (Type Information Not Retained)
When type parameters are not reified, the type information is erased at runtime. Here's an example to demonstrate this:
*/
fun <T> printTypeInfo(value: T) {
    println("Type: ${value!!::class}")
}

//fun main() {
//    printTypeInfo("Hello")  // Type: class java.lang.String
//    printTypeInfo(123)      // Type: class java.lang.Integer
//    printTypeInfo(true)     // Type: class java.lang.Boolean
//}
/*
In this example, although we can get the runtime class of value using value::class, we cannot directly
use the type parameter T because it is erased at runtime.
 */

/*
With reified Type Parameters (Type Information Retained)
By using the reified keyword in an inline function, we can retain the type information at runtime. Here's how:
 */

inline fun <reified T> printReifiedTypeInfo() {
    println("Type: ${T::class}")
}

//fun main() {
//    printReifiedTypeInfo<String>()  // Type: class java.lang.String
//    printReifiedTypeInfo<Int>()     // Type: class java.lang.Integer
//    printReifiedTypeInfo<Boolean>() // Type: class java.lang.Boolean
//}

/*
In this example, because the function is inline and the type parameter T is reified, we can access
the type information of T at runtime using T::class.
 */
