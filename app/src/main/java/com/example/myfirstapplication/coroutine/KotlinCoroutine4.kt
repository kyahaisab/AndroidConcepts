package com.example.myfirstapplication.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/*
- To cancel a coroutine it has to be cooperative and 2 then in simultaneously job.cancel() and job.join()
When this function is called, then if the coroutine is cooperative it will cancel the coroutine.
Else if the coroutine is not cooperative then it will wait for the coroutine to finish.

- It is so frequent that a separate fun is made job.cancelAndJoin()

- What exactly we mean by cooperative?What makes a coroutine cooperative?Well, there are basically two ways to
make a coroutine cooperative.Now,
*the first way is to periodically invoke a suspending function that checks for
cancellation. And only those suspending functions which belong to kotlinx.coroutines package will make your
coroutine cooperative and therefore cancellable.For example, the functions like delay, yield etc are the suspending
functions which belong to that package.And if you use these functions in your coroutine, then your coroutine will become
cooperative and therefore it can be cancelled by calling the cancel function

* Using isActive
*/

/*fun main() {
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")

        val job: Job = launch {
            for (i in 0..300) {
                print("$i.")
                //Thread.sleep(50) // this is non cooperative
                //delay(50) // this is cooperative
                yield() // This will make your job cooperative
            }
        }
        delay(200)
        job.cancel() // ideally job should get cancelled after 200 ms but it is not, because sleep and print are not cooperative fun
        job.join()

        println("Main program Ended: ${Thread.currentThread().name}")
    }
}*/

/*
fun main() {
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")

        val job: Job = launch(Dispatchers.Default) {
            for (i in 0..300) {
                print("$i.")
                if (!isActive) break // This will can cancel the job after 100 ms, proving this is cooperative
                Thread.sleep(10)
            }
        }
        delay(100)
        job.cancelAndJoin() // same as cancel() then join()

        println("Main program Ended: ${Thread.currentThread().name}")
    }
}
*/


/*
In short, all the cancellable suspending functions such as yield, delay present in coroutine package
throw CancellationException when the coroutine is cancelled.
 */
/*
fun main() {
    runBlocking {
        println("Main program starts: ${Thread.currentThread().name}")

        val job: Job = launch(Dispatchers.Default) {
            try {
                for (i in 0..300) {
                    print("$i.")
                    delay(10)
                }
            } catch (e: Exception) {
                println("Exception: ${e.message}")
            } finally {
                println("Finally job ends")
            }
        }
        delay(100)
        job.cancelAndJoin() // same as cancel() then join()

        println("Main program Ended: ${Thread.currentThread().name}")
    }
}*/
