package com.example.myfirstapplication.servicesProject.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.click
import com.example.myfirstapplication.databinding.ActivityStartedServiceBinding
import com.example.myfirstapplication.servicesProject.services.MyStartedService

class StartedServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartedServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartedServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startServiceButton.click {
            // Rename service name to MyStartedServiceCustomLooperHandler to see that service action in start and stop button
            val serviceIntent = Intent(this, MyStartedService::class.java)
            startService(serviceIntent)
        }

        binding.stopServiceButton.click {
            val serviceIntent = Intent(this, MyStartedService::class.java)
            stopService(serviceIntent)
        }
    }
}