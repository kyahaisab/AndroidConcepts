package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myfirstapplication.coroutine.CustomLooperHandlerActivity
import com.example.myfirstapplication.coroutine.ThreadImplActivity
import com.example.myfirstapplication.coroutineAmit.CoroutineOne
import com.example.myfirstapplication.retrofitDaggerCorutine.BaseRetrofitActivity

class MainActivity : ComponentActivity() {
    private lateinit var startThreadButton: Button
    private lateinit var looperHandlerButton: Button
    private lateinit var learnCoroutineButton: Button
    private lateinit var retrofitDaggerButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThreadButton = findViewById(R.id.threadButton)
        looperHandlerButton = findViewById(R.id.customLooperAndHandler)
        learnCoroutineButton = findViewById(R.id.coroutineTesting)
        retrofitDaggerButton = findViewById(R.id.retrofitDaggerCoroutine)

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
        retrofitDaggerButton.click {
            startActivity(Intent(this, BaseRetrofitActivity::class.java))
        }
    }
}