package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myfirstapplication.coroutine.ThreadImplActivity

class MainActivity : ComponentActivity() {
    private lateinit var startThreadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThreadButton = findViewById(R.id.threadButton)
        startThreadButton.setOnClickListener {
            startActivity(Intent(applicationContext, ThreadImplActivity::class.java))
        }
    }
}