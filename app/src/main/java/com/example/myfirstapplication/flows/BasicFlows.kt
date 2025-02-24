package com.example.myfirstapplication.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Types of Flow
 * Cold Flow — It does not start producing values until one starts to collect them. It can have only one subscriber. e.g. flow
 * Hot Flow — It will produce values even if no one is collecting them.
 * e.g. StateFlow, SharedFlow
 */
fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}


fun testSimpleFlow() {
    runBlocking {
        simpleFlow()
            .map { it * 2 }
            .collect {
                println("Received: $it")
            }
    }
}


fun testTransform() {
    runBlocking {
        simpleFlow()
            .transform {
                emit("Before $it")
                emit(it.toString())  // Emit multiple values for each item
                emit("After $it")
            }
            .collect { println(it) }
    }
}


// StateFlow holds the latest value and emits it immediately to new collectors.
fun testHotFlows() {
    runBlocking {
        val stateFlow = MutableStateFlow(0)

        launch {
            stateFlow.collect { println("StateFlow: $it") }
        }

        stateFlow.value = 1
        stateFlow.value = 2
        stateFlow.value = 3
    }
}

fun main() {
    //testSimpleFlow()
    //testTransform()
    //testHotFlows()
}


/**
 * Comparison of Flow, LiveData, and RxJava
 *
 * | Feature       | Flow (Kotlin)      | LiveData (Android)    | RxJava (ReactiveX)  |
 * |--------------|-------------------|------------------------|---------------------|
 * | Threading    | Coroutine-based   | Main thread (default)  | RxSchedulers       |
 * | Cold/Hot     | Cold (default)     | Hot (always active)   | Cold & Hot         |
 * | Operators    | Yes (map, filter, etc.) | Limited          | Powerful           |
 * | Backpressure | Handled automatically   | Not an issue       | Requires handling  |
 */
