package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.myfirstapplication.coroutine.CustomLooperHandlerActivity
import com.example.myfirstapplication.coroutine.ThreadImplActivity
import com.example.myfirstapplication.coroutineAmit.CoroutineOne
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.example.myfirstapplication.di.BaseDIActivity
import com.example.myfirstapplication.learnFragments.LearnFragmentsActivity
import com.example.myfirstapplication.recyclerViews.MainActivity2
import com.example.myfirstapplication.utils.click

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()
    }

    private fun setViews() {
        binding.threadButton.setOnClickListener {
            startActivity(Intent(this, ThreadImplActivity::class.java))
        }
        binding.customLooperAndHandler.setOnClickListener {
            startActivity(Intent(this, CustomLooperHandlerActivity::class.java))
        }
        binding.coroutineTesting.setOnClickListener {
            startActivity(Intent(this, CoroutineOne::class.java))
        }
        binding.diTesting.click {
            startActivity(Intent(this, BaseDIActivity::class.java))
        }
        binding.recyclerView.click {
            startActivity(Intent(this, MainActivity2::class.java))
        }
        binding.fragmentPlay.click {
            startActivity(Intent(this, LearnFragmentsActivity::class.java))
        }
    }
}