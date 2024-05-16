package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myfirstapplication.coroutine.CustomLooperHandlerActivity
import com.example.myfirstapplication.coroutine.ThreadImplActivity
import com.example.myfirstapplication.coroutineAmit.CoroutineOne

class MainActivity : ComponentActivity() {
    private lateinit var startThreadButton: Button
    private lateinit var looperHandlerButton: Button
    private lateinit var learnCoroutineButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThreadButton = findViewById(R.id.threadButton)
        looperHandlerButton = findViewById(R.id.customLooperAndHandler)
        learnCoroutineButton = findViewById(R.id.coroutineTesting)

        setViews()
    }

    private fun setViews() {
        startThreadButton.setOnClickListener {
            startActivity(Intent(this, ThreadImplActivity::class.java))
        }
        looperHandlerButton.setOnClickListener {
            startActivity(Intent(this, CustomLooperHandlerActivity::class.java))
        }
        learnCoroutineButton.setOnClickListener {
            startActivity(Intent(this, CoroutineOne::class.java))
        }
    }
}