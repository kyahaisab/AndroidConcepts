package com.example.myfirstapplication.servicesProject.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.databinding.ActivityForegroundServiceBinding
import com.example.myfirstapplication.servicesProject.services.MyForegroundService

class ForegroundServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForegroundServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForegroundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.startServiceButton.setOnClickListener {
            Intent(this, MyForegroundService::class.java).also { intent ->
                startService(intent)
            }
        }

        binding.stopServiceButton.setOnClickListener {
            Intent(this, MyForegroundService::class.java).also { intent ->
                stopService(intent)
            }
        }
    }
}