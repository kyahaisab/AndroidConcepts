package com.example.myfirstapplication.workManager.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "system_resources")
data class SystemResource(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val timestamp: Long,
    val cpuUsage: Float,
    val memoryUsage: Float
)