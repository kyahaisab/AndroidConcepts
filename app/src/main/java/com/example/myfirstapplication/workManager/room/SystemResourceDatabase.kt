package com.example.myfirstapplication.workManager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SystemResource::class], version = 1, exportSchema = false)
abstract class SystemResourceDatabase : RoomDatabase() {
    abstract fun systemResourceDao(): SystemResourceDao

    companion object {
        @Volatile
        private var INSTANCE: SystemResourceDatabase? = null

        fun getDatabase(context: Context): SystemResourceDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SystemResourceDatabase::class.java,
                    "system_resource_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


