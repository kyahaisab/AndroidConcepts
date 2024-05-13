package com.example.myfirstapplication.coroutine

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.databinding.ActivityCustomeLooperHandlerBinding
import kotlin.concurrent.thread

class CustomLooperHandlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomeLooperHandlerBinding
    private lateinit var looperThread: LooperThread
    private var stopLoop = false
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomeLooperHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* 1.
         We will create our own thread, which will behave like looper(just like UI thread is in constant loop).
         Also create one more thread that will perform task and put task to custom looper via handler
         If needed we will update main thread from looper thread
         */
        Log.d("Main thread ID: ", "${Thread.currentThread().id}")
        setupViews()
    }

    private fun setupViews() {
        looperThread = LooperThread()
        looperThread.start()

        binding.startThread.setOnClickListener {
            stopLoop = true
            executeOnCustomLooperWithCustomHandler()
        }

        binding.stopThread.setOnClickListener {
            stopLoop = false
        }
    }

    private fun executeOnCustomLooperWithCustomHandler() {
        looperThread.handler.post {
            while (stopLoop) {
                Thread.sleep(500)
                count++
                Log.d("Thread id is of runnable posted ", "${Thread.currentThread().id}")
                runOnUiThread {
                    Log.d(
                        "Thread id is of run on ui thread: ",
                        "${Thread.currentThread().id} and count: $count"
                    )
                    binding.textViewCtLoop.text = count.toString()
                }
            }
        }
    }

    private fun executeOnCustomLooper() {
        thread {
            while (stopLoop) {
                Log.d("Thread that sends message: ", "${Thread.currentThread().id}")
                Thread.sleep(500)
                count++
                var message = Message()
                message.obj = "" + count
                looperThread.handler.sendMessage(message)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // To prevent LooperThread run method running for infinity for infinity
        if (looperThread.isAlive)
            looperThread.handler.looper.quit()
    }
}

class LooperThread : Thread() {
    lateinit var handler: Handler
    override fun run() {
        // This thread will be in constant loop for infinity
        Looper.prepare()
        handler = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.d("LooperThread class", "${Thread.currentThread().id} message= ${msg.obj}")
            }
        }
        Looper.loop()
    }
}