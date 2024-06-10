package com.example.myfirstapplication.coroutine

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R
import com.example.myfirstapplication.kotlinOOP.findIndex
import kotlin.concurrent.thread

// Source: https://www.youtube.com/watch?v=xYAXqgbc2LY&list=PLfuE3hOAeWhYspjqABfkf97AzW1XNXgjZ&index=6
class ThreadImplActivity : AppCompatActivity() {
    private var stopLoop = true
    private lateinit var tvResult: TextView
    private var counter = 0
    private lateinit var handler: Handler
    private lateinit var myAsyncTask: MyAsyncTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_impl)
        // Say ID is 2
        Log.d("Initial Thread", Thread.currentThread().id.toString())
        /*
        1.
        An app is a process, which can have any no of threads and one of the thread is UI thread, there you UI tasks
        are executes, like click of button, etc
         */

        tvResult = findViewById(R.id.textViewCt)
        handler = Handler(applicationContext.mainLooper)
    }

    fun startThreadFunction(view: View) {
        /*
         // Running in UI Thread so it will block the thread and crash, it is resource intensive operation
         // So it should be done on other thread, not on UI thread
         stopLoop = true
         while (stopLoop) {
             // There ID is also 2
             Log.d("Threads", Thread.currentThread().id.toString())
         }*/
        /*

                thread {
                    stopLoop = true
                    while (stopLoop) {
                        // There it will show different thread id, and app will not crash as well
                        // because it is running on different thread
                        Log.d("Threads", Thread.currentThread().id.toString())
                        counter++
                        // updating here the textview may give exception because tv was created in other thread and being updated
                        // in other thread, or if it is updated successfully then it will lead to synchronisation issues.
                        // Always update tv on ui thread
                        // tvResult.text = counter.toString()

                        // 2. Looper and handler
                        // So better way is to use looper and handler
                        // Main thread is in constant loop, so we put task(in form of runnable) from background thread to message queue
                        // of UI thread using Handler. We create another thread from main thread, from the other thread we do some task and
                        // update our main thread using handler and put task to main thread in form of runnable
                        handler.post(Runnable {
                            tvResult.text = counter.toString()
                        })
                        // Shortcut of above stuff
                        tvResult.post {
                            Runnable {
                                tvResult.text = counter.toString()
                            }
                        }
                    }
                }
        */
        // 3.
        // Updating UI thread from different thread is so frequent that android have created a separate API for this purpose
        // Async Task- to do long task without blocking main thread, it has 4 methods

        myAsyncTask = MyAsyncTask()
        myAsyncTask.execute(12)
    }

    fun stopThreadFunction(view: View) {
        stopLoop = false
        // Another way of stopping async task
        // Once async task is stopped you cannot start the same async task
        // myAsyncTask.cancel(true)
    }

    @SuppressLint("StaticFieldLeak")
    inner class MyAsyncTask : AsyncTask<Int, Int, Int>() {
        private var customCounter = 0

        @Deprecated("Deprecated in Java")
        override fun onPreExecute() {
            super.onPreExecute()
            customCounter = 99
        }

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: Int?): Int {
            customCounter = params[0]!!
            while (this@ThreadImplActivity.stopLoop) {
                customCounter++
                publishProgress(counter)
                Thread.sleep(1000)

                // When async task is cancelled using myAsyncTask.cancel(true)
                if (isCancelled) {
                    break
                }
            }
            return customCounter
        }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            tvResult.text = result.toString()
        }

        @Deprecated("Deprecated in Java")
        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            tvResult.text = values.toString()
        }

        @Deprecated("Deprecated in Java")
        override fun onCancelled() {
            super.onCancelled()
        }
    }
}