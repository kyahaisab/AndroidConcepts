package com.example.myfirstapplication.workManager.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myfirstapplication.workManager.retrofit.RetrofitInstance
import com.example.myfirstapplication.workManager.room.SystemResourceDatabase

class DataSyncWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val database = SystemResourceDatabase.getDatabase(applicationContext)
        val resources = database.systemResourceDao().getAllResources().value ?: emptyList()

        return if (resources.isNotEmpty()) {
            try {
                val response = RetrofitInstance.api.sendResources(resources)
                if (response.isSuccessful) {
                    // Clean the data from the database if sent successfully
                    resources.forEach { database.systemResourceDao().deleteResource(it) }
                    Result.success()
                } else {
                    Result.retry()
                }
            } catch (e: Exception) {
                Result.retry()
            }
        } else {
            Result.success()
        }
    }
}
