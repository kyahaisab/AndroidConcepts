package com.example.myfirstapplication.workManager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfirstapplication.workManager.room.SystemResource
import com.example.myfirstapplication.workManager.room.SystemResourceDao
import com.example.myfirstapplication.workManager.room.SystemResourceDatabase

class SystemResourceViewModel(application: Application, private val resourceDao: SystemResourceDao) : AndroidViewModel(application) {
    val allResources: LiveData<List<SystemResource>> = resourceDao.getAllResources()
}
