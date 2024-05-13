package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() { // Executes in main thread and statement inside it also runs in main thread, unless another thread is made inside
    println("Main program starts: ${Thread.currentThread().name}")
    /*
        thread { // Creates a background thread(worker thread), Also a "daemon" thread is a thread that runs in the background and
            // does not prevent the JVM from exiting when the program finishes. This is non-deamon thread so program will wait for it to end
            println("Fake work start: ${Thread.currentThread().name}")
            Thread.sleep(1000)
            println("Fake work completed: ${Thread.currentThread().name}")
        }
        */

    // 2. Same as above, doing with coroutine
    // App will not wait for background co routine, so nothing is printed inside this, we need amke it wait manually. This might be
    // because it may be running in deamon thread(My guess and logic not sure)
    GlobalScope.launch {  // Create a background coroutine that runs on background thread
        println("Fake work start: ${Thread.currentThread().name}")
        //Thread.sleep(1000) // - Important: Now, this Thread.sleep basically blocks the entire thread.So if some other coroutines are
        // operating within the same thread as this coroutine is operating, then it will basically block that other coroutine as well.
        // so use delay instead of sleep

        delay(1000) // - This(delay-a suspend fun) will not block the thread where this coroutine is working, so other coroutine working on this thread are
        // working and only our desired coroutine gets block
        // - Say this coroutine stared in thread T1 and after sleep it will again start on same thread T1, but with delay it may oe may not start on T1, because T1
        // is freed from this coroutine and T1 might get involved in some other work.
        println("Fake work completed: ${Thread.currentThread().name}")
    }

    // - To make co routine finish its work and main thread to wait
    //Thread.sleep(2000) // without this, coroutine part is not completed and nothing printed on consol

    // - Alternative of above, because delay can't run on thread, so to use delay use coroutine run blocking
    runBlocking {// creates coroutine that block the current thread where its put on(in our case its main thread)
        delay(2000)// wait for coroutine to finish work(not good way to wait)
    }
    /*
    Summary:
    launch function creates a coroutine that does not block the main thread.
    But runBlocking creates a coroutine that blocks the main thread.
     */

    /*
    Suspend Function: can be called from coroutine or from other suspend function
     */

    // Both main thread and background thread runs in parallel, concurrent manner. So code of background thread does not block main thread
    println("Main program ends: ${Thread.currentThread().name}")
}