package com.example.myfirstapplication.flows

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * By Cheezy code:
 *
 * Link: https://www.youtube.com/watch?v=kOpRhtbhftI&list=PLRKyZvuMYSIPJ84lXQSHMn8P-0J8jW5YT&index=1&t=61s
 */

// Lecture One
/**
 * A suspend function returns a single object. However, there are scenarios where we need to send a stream of data, such as:
 * - Video streaming
 * - FM radio
 * - Bluetooth transmitting audio signals to a speaker
 * - GPS providing location data in the form of continuous streams
 */

private suspend fun getUser(id: Int): String {
    delay(1000) // Simulating a network call
    return "User$id"
}

/**
 * The major drawback of using suspend functions in such cases is that they collect the entire list before sending it to the main function.
 * Ideally, we should send each element as soon as it is available, rather than waiting for all data to be collected.
 * This reduces latency and improves efficiency. Streams help solve this problem.
 */
private suspend fun getUserNames(): List<String> {
    val list = mutableListOf<String>()
    list.add(getUser(1))
    list.add(getUser(2))
    list.add(getUser(3))
    return list
}

private fun testSuspendOneTimeDataOperation() {
    runBlocking {
        getUserNames().forEach {
            println("Flows: $it")
        }
    }
}

/**
 * To support asynchronous streaming in Kotlin, we have two main options:
 *
 * 1. **Channels (Hot Streams) - Send and Receive**
 *    - Data is continuously produced, regardless of whether a consumer is present.
 *    - Example: Radio stations continuously transmit audio. If a song starts at 4:00 PM and you tune in at 4:15 PM,
 *      you will only receive data from 4:15 onward, missing the previous 15 minutes.
 *
 * 2. **Flows (Cold Streams) - Emit and Collect**
 *    - Data is produced only when a consumer is present.
 *    - If you start consuming at 4:15 PM, you will receive the data from the beginning, as if the stream started just for you.
 */


/**
 * Testing Channels
 */
class SimpleClass {
    private val channel = Channel<Int>() // Declare the channel
    fun start() {
        val scope = CoroutineScope(Dispatchers.Default) // Define a coroutine scope


        // Launch producer and consumer
        scope.launch { producer() }
        scope.launch { consumer() }
    }

    private suspend fun producer() {
        channel.send(1)
        channel.send(2)
        channel.close() // Close the channel after sending all items
    }

    private suspend fun consumer() {
        for (item in channel) {
            println("CHEEZYFLOWS: $item") // Print output
        }
    }
}

fun testChannels() {
    val simpleClass = SimpleClass()
    simpleClass.start()

    // Add a delay to keep the main function alive while coroutines run
    runBlocking {
        delay(2000) // Allow time for coroutines to complete
    }
}

fun main() {
    // Uncomment the function you want to test
    // testSuspendOneTimeDataOperation()
    testChannels()
}

