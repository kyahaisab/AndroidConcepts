package com.example.myfirstapplication.workManager.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myfirstapplication.workManager.room.SystemResource
import com.example.myfirstapplication.workManager.room.SystemResourceDatabase

class ResourceTrackingWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val cpuUsage = getCPUUsage()
        val memoryUsage = getMemoryUsage()

        val systemResource = SystemResource(
            timestamp = System.currentTimeMillis(),
            cpuUsage = cpuUsage,
            memoryUsage = memoryUsage
        )

        val database = SystemResourceDatabase.getDatabase(applicationContext)
        database.systemResourceDao().insertResource(systemResource)

        return Result.success()
    }

    private fun getCPUUsage(): Float {
        // Mock CPU usage data. Replace with actual implementation.
        return (0..100).random().toFloat()
    }

    private fun getMemoryUsage(): Float {
        // Mock memory usage data. Replace with actual implementation.
        return (0..100).random().toFloat()
    }
}
