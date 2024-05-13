package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myfirstapplication.coroutine.CustomLooperHandlerActivity
import com.example.myfirstapplication.coroutine.ThreadImplActivity

class MainActivity : ComponentActivity() {
    private lateinit var startThreadButton: Button
    private lateinit var looperHandlerButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThreadButton = findViewById(R.id.threadButton)
        looperHandlerButton = findViewById(R.id.customLooperAndHandler)

        setViews()
    }

    private fun setViews() {
        startThreadButton.setOnClickListener {
            startActivity(Intent(this, ThreadImplActivity::class.java))
        }
        looperHandlerButton.setOnClickListener {
            startActivity(Intent(this, CustomLooperHandlerActivity::class.java))
        }
    }
}