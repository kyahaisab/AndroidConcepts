package com.example.myfirstapplication.coroutineAmit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myfirstapplication.utils.click
import com.example.myfirstapplication.databinding.ActivityCoroutineOneBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineOne : AppCompatActivity() {
    /*
    Task 1: See logcat for each button press
    Task 2: See logcat by clicking on button and then going back to previous screen in few sec
     */

    private lateinit var binding: ActivityCoroutineOneBinding
    private val myActivityScope = CoroutineScope(Dispatchers.Main.immediate)
    private val myActivityScope1 =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate) // this is like lifecycle scope, it can be used again, after getting cancelled due to error

    companion object {
        private const val TAG = "BasicActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        // As we need to do it manually
        myActivityScope.cancel()
    }

    private fun setViews() {
        binding.testCoroutine.click {
            testCoroutine()
        }

        binding.testCoroutineWithMain.click {
            testCoroutineWithMain()
        }

        binding.testCoroutineWithMainImmediate.click {
            testCoroutineWithMainImmediate()
        }

        binding.testCoroutineEverything.click {
            testCoroutineWithEverything()
        }

        binding.usingGlobalScope.click {
            usingGlobalScope()
        }

        binding.usingMyActivityScope.click {
            usingMyActivityScope()
        }

        binding.globalScopeInsideLifecycleScope.click {
            globalScopeInsideLifecycleScope()
        }

        binding.launchInsideLifecycleScope.click {
            launchInsideLifecycleScope()
        }

        binding.twoLaunches.click {
            twoLaunches()
        }

        binding.twoWithContextInsideLifecycleScope.click {
            twoWithContextInsideLifecycleScope()
        }

        binding.twoAsyncInsideLifecycleScope.click {
            twoAsyncInsideLifecycleScope()
        }

        binding.twoTasks.click {
            twoTasks()
        }

        binding.parentAndChildTaskCancel.click {
            parentAndChildTaskCancel()
        }

        binding.parentAndChildTaskCancelIsActive.click {
            parentAndChildTaskCancelIsActive()
        }

        binding.lifecycleScopeHandlerWithException.click {
            lifecycleScopeWithHandlerException()
        }

        binding.lifecycleScopeWithHandler.click {
            lifecycleScopeWithHandler()
        }

        binding.myActivityScopeWithHandlerException.click {
            myActivityScopeWithHandlerException()
        }

        binding.myActivityScopeWithHandler.click {
            myActivityScopeWithHandler()
        }

        binding.exceptionInLaunchBlock.click {
            exceptionInLaunchBlock()
        }

        binding.exceptionInAsyncBlock.click {
            exceptionInAsyncBlock()
        }

        binding.exceptionInAsyncBlockWithAwait.click {
            exceptionInAsyncBlockWithAwait()
        }
    }

    private fun testCoroutine() {
        Log.d(TAG, "Function Start")

        // Here dispatcher is not defined, it is Dispatchers.Main.immediate by default
        // Scope created by kotlin developer, they kept Dispatchers.Default as default dispatcher
        // Scope created by Google developer, Dispatchers.Main.immediate as default dispatcher like lifecycle, viewmodel scopes
        lifecycleScope.launch {
            Log.d(TAG, "Before task")
            doLongRunningTask()
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun testCoroutineWithMain() {
        Log.d(TAG, "Function Start")

        // Dispatchers.Main->This is equivalent to handler.post{}, means it will be queued and take little time
        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before task")
            doLongRunningTask()
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun testCoroutineWithMainImmediate() {
        Log.d(TAG, "Function Start")

        // Dispatchers.Main.immediate->immediate means do it know, run on main thread now.
        lifecycleScope.launch(Dispatchers.Main.immediate) {
            Log.d(TAG, "Before task")
            // suppose instead of below we are doing some db operation, then our thread is not suspended, then order is
            // F Start->B Task-> db operation->A Task->F End, because thread is not suspended(free) to F End
            doLongRunningTask() // now main thread is (suspended)free to do some other task
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun testCoroutineWithEverything() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before task 1")
            doLongRunningTask()
            // Either after task 1 or after task 2 anyone of them is printed first, which will be finished first
            Log.d(TAG, "After task 1")
        }

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before task 2")
            doLongRunningTask()
            Log.d(TAG, "After task 2")
        }

        Log.d(TAG, "Function End")
    }

    private fun usingGlobalScope() {
        Log.d(TAG, "Function Start")

        // This scope is created by Kotlin, so dispatcher is Dispatchers.Default
        GlobalScope.launch {
            Log.d(TAG, "Before task")
            doLongRunningTask()
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun usingMyActivityScope() {
        Log.d(TAG, "Function Start")

        myActivityScope.launch {
            Log.d(TAG, "Before task")
            doLongRunningTask()
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }


    private suspend fun doLongRunningTask() {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "Before delay")
            delay(2000)
            Log.d(TAG, "After delay")
        }
    }

    private suspend fun doLongRunningTaskOne(): Int {
        return withContext(Dispatchers.Default) {
            delay(2000)
            return@withContext 10
        }
    }

    private suspend fun doLongRunningTaskTwo(): Int {
        return withContext(Dispatchers.Default) {
            delay(2000)
            return@withContext 10
        }
    }

    private fun globalScopeInsideLifecycleScope() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before task")

            // below is a suspend fun then F Start->B Task->F End->A Task
            GlobalScope.launch(Dispatchers.Default) {
                Log.d(TAG, "Before delay")
                delay(2000)
                Log.d(TAG, "After delay")
            }
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun launchInsideLifecycleScope() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before task")

            // If scope is not mentioned it means, it inherits scope from its immediate parent
            launch(Dispatchers.Default) {
                Log.d(TAG, "Before delay")
                delay(2000)
                Log.d(TAG, "After delay")
            }
            Log.d(TAG, "After task")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoLaunches() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Before delay 1")
            delay(2000)
            Log.d(TAG, "After delay 1")
        }

        lifecycleScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Before delay 2")
            delay(2000)
            Log.d(TAG, "After delay 2")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoWithContextInsideLifecycleScope() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before task 1")
            val resultOne = doLongRunningTaskOne()
            Log.d(TAG, "After task 1")

            Log.d(TAG, "Before task 2")
            val resultTwo = doLongRunningTaskTwo()
            Log.d(TAG, "After task 2")

            Log.d(TAG, "result: ${resultOne + resultTwo}")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoAsyncInsideLifecycleScope() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before Task")

            val deferredOne = async { doLongRunningTaskOne() }
            val deferredTwo = async { doLongRunningTaskTwo() }

            val result = deferredOne.await() + deferredTwo.await()
            Log.d(TAG, "result: $result")

            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoTasks() {
        Log.d(TAG, "Function Start")

        val job = lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 1")
            doLongRunningTask()
            Log.d(TAG, "After Task 1")
        }

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 2")
            job.cancel()
            doLongRunningTask()
            Log.d(TAG, "After Task 2")
        }

        Log.d(TAG, "Function End")
    }

    private fun parentAndChildTaskCancel() {
        Log.d(TAG, "Function Start")

        val job = lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task")
            coroutineContext[Job]?.let { childTask(it) } // same as val job=lifecycle...
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    // Its li
    private suspend fun childTask(parent: Job) {
        // with context does not launch coroutine , it just change the dispatcher, so id parent job is cancelled then childTask is also cancelled
        withContext(Dispatchers.Default) {
            Log.d(TAG, "child task start")
            parent.cancel()
            Log.d(
                TAG,
                "child task parent cancel"
            ) // Even after cancel this line got printed, remedy is by using isActive
            delay(2000)
            Log.d(TAG, "child task End")
        }
    }

    private fun parentAndChildTaskCancelIsActive() {
        Log.d(TAG, "Function Start")

        val job = lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task")
            coroutineContext[Job]?.let { childTaskWithIsActive(it) }
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private suspend fun childTaskWithIsActive(parent: Job) {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "child task start")
            parent.cancel()
            if (isActive) Log.d(
                TAG,
                "child task parent cancel"
            ) // remedy of above problem, this line inot getting printed
            delay(2000)
            Log.d(TAG, "child task End")
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        Log.d(TAG, "exception handler: $e")
    }

    private fun lifecycleScopeWithHandlerException() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            throw Exception("Some Exception")
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun lifecycleScopeWithHandler() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun myActivityScopeWithHandlerException() {
        Log.d(TAG, "Function Start")

        // IMP: if any error comes in this scope the complete scope gets cancelled, we cannot reuse this scope to launch any coroutine
        myActivityScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            throw Exception("Some Exception") // now myActivityScope will be cancelled for ever and we cannot use it in next operation
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun myActivityScopeWithHandler() {
        Log.d(TAG, "Function Start")

        myActivityScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun exceptionInLaunchBlock() {
        // It will through exception and activity closes unless you handel it by: launch(exceptionHandler)
        lifecycleScope.launch {
            doSomethingAndThrowException()
        }
    }

    private fun exceptionInAsyncBlock() {
        // Exception is thrown but it is contained in it and activity will not crash unless unless we use await
        lifecycleScope.async {
            doSomethingAndThrowException()
        }
    }

    private fun doSomethingAndThrowException() {
        throw Exception("Some Exception")
    }

    private fun exceptionInAsyncBlockWithAwait() {
        lifecycleScope.launch {
            val deferred = lifecycleScope.async(Dispatchers.Default) {
                doSomethingAndThrowException()
                return@async 10
            }
            try {
                val result = deferred.await()
            } catch (e: Exception) {
                Log.d(TAG, "Exception Handler: $e")
            }
        }
    }

    //NOTE: difference between launch and async is one returns job and other returns deferred job(we can get result)
    // NOTE: make short bullet points about every topic, so that they are easy to revise
}