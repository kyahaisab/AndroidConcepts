package com.example.myfirstapplication.flows

/**
 * Lesson 2
 */

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Cold streams (Flows) are preferred over hot streams because hot streams can lead to resource wastage
 * and require manual management to close them.
 */

/**
 * This example demonstrates a scenario where the producer generates data at a high rate while
 * the consumer processes it at a different pace (either slower or faster).
 * Instead of blocking threads, we use coroutines to suspend execution efficiently.
 */
class FlowProducer {
    /**
     * A cold Flow that emits numbers from 1 to 10 with a delay of 1 second between emissions.
     * Since Flows are cold, each new collector starts receiving values from the beginning.
     */
    private fun producer(): Flow<Int> = flow {
        val numbers = (1..10).toList()
        for (num in numbers) {
            delay(1000) // Simulating asynchronous data emission
            emit(num)  // Emit each number
        }
    }

    /**
     * Demonstrates multiple consumers collecting from the same Flow.
     * Each consumer starts from the beginning when it starts collecting.
     */
    suspend fun startCollecting() {
        // Launching consumers in separate coroutines
        val job1 = GlobalScope.launch {
            producer().collect { println("Consumer One received: $it") }
        }

        val job2 = GlobalScope.launch {
            producer().collect { println("Consumer Two received: $it") }
        }

        // A third consumer starts late and still receives values from the beginning
        val job3 = GlobalScope.launch {
            delay(2500) // Introduce a delay before starting collection
            producer().collect { println("Consumer Three received: $it") }
        }

        // Keep the main thread alive to allow flows to complete
        delay(15000)
        // Cancel coroutines to prevent memory leaks
        job1.cancel()
        job2.cancel()
        job3.cancel()
    }
}

fun main() = runBlocking {
    val flowProducer = FlowProducer()
    flowProducer.startCollecting()
}
