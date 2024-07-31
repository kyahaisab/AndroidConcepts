package com.example.myfirstapplication.workManager.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SystemResourceDao {
    @Query("SELECT * FROM system_resources ORDER BY timestamp DESC")
    fun getAllResources(): LiveData<List<SystemResource>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResource(resource: SystemResource)

    @Delete
    suspend fun deleteResource(resource: SystemResource)
}
