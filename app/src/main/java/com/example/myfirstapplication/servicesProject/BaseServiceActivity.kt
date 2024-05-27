package com.example.myfirstapplication.servicesProject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.click
import com.example.myfirstapplication.databinding.ActivityBaseServiceBinding
import com.example.myfirstapplication.servicesProject.activities.BoundServiceActivity
import com.example.myfirstapplication.servicesProject.activities.ForegroundServiceActivity
import com.example.myfirstapplication.servicesProject.activities.StartedServiceActivity

class BaseServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.startedServiceButton.click {
            startActivity(Intent(this, StartedServiceActivity::class.java))
        }
        binding.boundServiceButton.click {
            startActivity(Intent(this, BoundServiceActivity::class.java))
        }
        binding.foregroundServiceButton.click {
            startActivity(Intent(this, ForegroundServiceActivity::class.java))

        }
    }
}
