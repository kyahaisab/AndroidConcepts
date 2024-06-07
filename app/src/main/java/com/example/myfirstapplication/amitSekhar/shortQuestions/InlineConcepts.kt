package com.example.myfirstapplication.amitSekhar.shortQuestions

fun guide() {
    println("Guide Start")
    teach()
    beatStudent()
    println("Guide end")
}

// This fun is not pasted as it is inside guide function whereas teach() fun does. See inside OOP module->lambdas
// *************IMP: Decompile code and see difference: open this file->tool->kotlin->show kotlin bytecode->decompile
fun beatStudent() {
    println("Beating student")
}

inline fun teach() {
    println("teaching")
}

/*
1. Advantage of inline function: is that the function call Overhead doesn't occur and the less overhead
and the faster program execution
2. When to use:
   when the function code is very small it's a good idea to make the function inline but when the function code
   is large and called from so many places it's a bad idea to make the function in line as the large code will be repeated.
 */