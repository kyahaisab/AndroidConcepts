package com.example.myfirstapplication.workManager.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapplication.workManager.room.SystemResourceDatabase

class SystemResourceViewModelFactory(
    private val application: Application
) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SystemResourceViewModel::class.java)) {
            val resourceDao = SystemResourceDatabase.getDatabase(application).systemResourceDao()
            @Suppress("UNCHECKED_CAST")
            return SystemResourceViewModel(application, resourceDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
