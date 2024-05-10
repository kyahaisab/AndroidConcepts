package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    var startBool = false
    private lateinit var buttonStart: Button
    private lateinit var buttonStop: Button
    private lateinit var text: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
        text = findViewById(R.id.textViewPrint)

        buttonStart.setOnClickListener {
            startBool = true

            while (startBool) {
                Log.i("Thread", "Hello World")
            }
        }
        buttonStop.setOnClickListener {
            startBool = false
        }
    }
}