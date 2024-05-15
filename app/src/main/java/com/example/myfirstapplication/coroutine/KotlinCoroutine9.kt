package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.*

/*
1. Coroutine Builders:
Coroutine builders are functions provided by Kotlin's kotlinx.coroutines library to create and launch coroutines.
-launch: Starts a new coroutine and returns a Job object representing the coroutine.
-async: Starts a new coroutine that computes a result asynchronously and returns a Deferred object representing the result.
-runBlocking: Blocks the current thread until the coroutine inside it completes.
-withContext: Suspends the coroutine until the provided coroutine context is switched.

2. Dispatchers:
Dispatchers determine the execution context or thread pool on which coroutines run. In Android, Dispatchers.Main is often used for UI-related operations,
while Dispatchers.IO is suitable for I/O-bound tasks like network requests.

fun main() {
    // Using IO dispatcher for network request
    GlobalScope.launch(Dispatchers.IO) {
        val result = fetchData()
        println("Data fetched: $result")
    }

    // Using Main dispatcher for UI update
    GlobalScope.launch(Dispatchers.Main) {
        updateUI()
    }
}

suspend fun fetchData(): String {
    delay(2000) // Simulating network delay
    return "Data from network"
}

suspend fun updateUI() {
    delay(1000)
    println("UI updated")
}

3. Coroutine Scopes in Android:
-In Android development, coroutine scopes are often tied to the lifecycle of UI components such as Activities or
Fragments to ensure that coroutines are cancelled when the associated UI component is destroyed, preventing memory
leaks and unnecessary resource consumption.

class MyViewModel : ViewModel() {

    fun fetchData() {
        viewModelScope.launch {
            val result = fetchDataFromRepository()
            println("Data fetched: $result")
        }
    }

    private suspend fun fetchDataFromRepository(): String {
        delay(2000) // Simulating network delay
        return "Data from repository"
    }
}
In this example, viewModelScope is a coroutine scope tied to the lifecycle of the ViewModel. Coroutines launched
within this scope are automatically cancelled when the associated ViewModel is cleared.
 */

/*
- WithContext:
is a coroutine builder used to temporarily switch the coroutine's context (thread) within a coroutine.
It suspends the current coroutine, switches to the specified context, executes the block of code provided,
and then returns to the original context. This is useful for
performing specific operations in a different context without changing the entire coroutine's context.
 */


fun main() {
    // Start a coroutine on the main thread
    GlobalScope.launch(Dispatchers.Main) {
        println("Coroutine started on ${Thread.currentThread().name}")

        // Perform some heavy computation on IO thread
        val result = withContext(Dispatchers.IO) {
            println("Heavy computation started on ${Thread.currentThread().name}")
            performHeavyComputation()
        }

        println("Result received: $result")
        println("Coroutine resumed on ${Thread.currentThread().name}")
    }

    // To keep the main thread alive
    Thread.sleep(2000)
}

suspend fun performHeavyComputation(): Int {
    delay(1000) // Simulating heavy computation
    return 42
}
