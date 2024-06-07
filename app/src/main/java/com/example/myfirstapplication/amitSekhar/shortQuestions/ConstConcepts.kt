package com.example.myfirstapplication.amitSekhar.shortQuestions

object ConstantsOne {
    val NAME = "Sagar"
}

fun testValueWithConstOne() {
    val name = ConstantsOne.NAME
}

//**************** Now use const keyword and decompile as mentioned in InlineConcepts
object ConstantsTwo {
    const val NAME = "Sonu"
}

fun testValueWithConstTwo() {
    val name = ConstantsTwo.NAME // here on decompile will get name="Sonu"
}

/*
Advantage:
The value has been inlined there will be no overhead to access the variable at the runtime and hence it will
lead to a better performance of the application so this is the advantage of using const val

About:
-const val defines a compile-time constant. This means that its value is determined at compile time and cannot be changed.
-val defines a runtime constant. Its value is determined at runtime when the class is instantiated.
-const val can only be used with primitive types (like Int, Float, Boolean, etc.) and String
 */