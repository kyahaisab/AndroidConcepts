package com.example.myfirstapplication.amitSekhar.shortQuestions


/*
Compile time refers to the period during which source code is translated into executable code.
This process is performed by a compiler. The compiler checks the source code for syntax errors.
e.g., missing semicolons in languages like C or Java, assigning a string to an integer variable.

Runtime refers to the period during which the program is actually executed, after it has been successfully compiled.
The program's behavior is determined based on input data and conditions encountered during execution.
eg. Division by zero, Null pointer dereference, File not found errors.
 */
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