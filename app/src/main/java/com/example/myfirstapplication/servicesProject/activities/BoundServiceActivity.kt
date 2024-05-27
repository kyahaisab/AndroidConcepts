package com.example.myfirstapplication.servicesProject.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.databinding.ActivityBoundServiceBinding
import com.example.myfirstapplication.servicesProject.services.MyBoundService

class BoundServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBoundServiceBinding

    private var myBoundService: MyBoundService? = null
    private var isBound = false

    // Defines callbacks for service binding, passed to bindService()
    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to MyBoundService, cast the IBinder and get MyBoundService instance
            val binder = service as MyBoundService.LocalBinder
            myBoundService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bindServiceButton.setOnClickListener {
            Intent(this, MyBoundService::class.java).also { intent ->
                bindService(intent, connection, Context.BIND_AUTO_CREATE)
            }
        }

        binding.unbindServiceButton.setOnClickListener {
            if (isBound) {
                unbindService(connection)
                isBound = false
            }
        }

        binding.getRandomNumberButton.setOnClickListener {
            if (isBound) {
                val num = myBoundService?.getRandomNumber()
                binding.randomNumberTextView.text = num.toString()
            }
        }
    }
}