package com.example.myfirstapplication.workManager

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myfirstapplication.R
import com.example.myfirstapplication.workManager.adapter.SystemResourceAdapter
import com.example.myfirstapplication.workManager.viewModel.SystemResourceViewModel
import com.example.myfirstapplication.workManager.viewModel.SystemResourceViewModelFactory
import com.example.myfirstapplication.workManager.worker.DataSyncWorker
import com.example.myfirstapplication.workManager.worker.ResourceTrackingWorker
import java.util.concurrent.TimeUnit

class WorkerHandlerActivity : AppCompatActivity() {

    companion object {
        fun getWorkerHandlerIntent(context: Context): Intent {
            return Intent(context, WorkerHandlerActivity::class.java)
        }
    }

    private lateinit var systemResourceViewModel: SystemResourceViewModel
    private lateinit var systemResourceAdapter: SystemResourceAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_handler)

        systemResourceAdapter = SystemResourceAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = systemResourceAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Use the ViewModelFactory to create the ViewModel
        val viewModelFactory = SystemResourceViewModelFactory(application)
        systemResourceViewModel = ViewModelProvider(this, viewModelFactory).get(SystemResourceViewModel::class.java)
        systemResourceViewModel.allResources.observe(this, Observer { resources ->
            resources?.let { systemResourceAdapter.setResources(it) }
        })

        // Schedule the WorkManager tasks
        scheduleWorkManagerTasks()
    }

    private fun scheduleWorkManagerTasks() {
        // Schedule the resource tracking work
        val resourceTrackingRequest = PeriodicWorkRequestBuilder<ResourceTrackingWorker>(15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "ResourceTrackingWork",
            ExistingPeriodicWorkPolicy.KEEP,
            resourceTrackingRequest
        )

        // Schedule the data sync work
        val dataSyncRequest = PeriodicWorkRequestBuilder<DataSyncWorker>(15, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DataSyncWork",
            ExistingPeriodicWorkPolicy.KEEP,
            dataSyncRequest
        )
    }
}