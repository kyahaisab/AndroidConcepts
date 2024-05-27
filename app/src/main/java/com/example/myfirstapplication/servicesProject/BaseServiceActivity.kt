package com.example.myfirstapplication.servicesProject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.click
import com.example.myfirstapplication.databinding.ActivityBaseServiceBinding
import com.example.myfirstapplication.servicesProject.services.MyStartedService

class BaseServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.startServiceButton.click {
            val serviceIntent = Intent(this, MyStartedService::class.java)
            startService(serviceIntent)
        }

        binding.stopServiceButton.click {
            val serviceIntent = Intent(this, MyStartedService::class.java)
            stopService(serviceIntent)
        }
    }
}
