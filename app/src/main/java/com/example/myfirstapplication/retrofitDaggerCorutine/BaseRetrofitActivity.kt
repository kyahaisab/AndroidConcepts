package com.example.myfirstapplication.retrofitDaggerCorutine

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import com.example.myfirstapplication.retrofitDaggerCorutine.adapter.UserAdapter
import com.example.myfirstapplication.retrofitDaggerCorutine.di.MyApplicationOne
import com.example.myfirstapplication.retrofitDaggerCorutine.repository.UserRepository
import com.example.myfirstapplication.retrofitDaggerCorutine.viewModel.UserViewModel
import com.example.myfirstapplication.retrofitDaggerCorutine.viewModel.UserViewModelFactory
import javax.inject.Inject

class BaseRetrofitActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(userRepository)
    }

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_retrofit)

        val applicationOne = (application as MyApplicationOne).appComponentOne
        applicationOne.inject(this)

        userAdapter = UserAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@BaseRetrofitActivity)
            adapter = userAdapter
        }

        userViewModel.users.observe(this, Observer { result ->
            when (result) {
                is com.example.myfirstapplication.retrofitDaggerCorutine.repository.Result.Error -> {
                    Log.d(
                        "BASE ACTIVITY",
                        "${result.exception.message}"
                    )
                }

                is com.example.myfirstapplication.retrofitDaggerCorutine.repository.Result.Success -> {
                    Log.d("BASE ACTIVITY", "${result.data}")
                    userAdapter.setUsers(result.data)
                }
            }
        })
    }
}