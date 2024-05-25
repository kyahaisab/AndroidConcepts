package com.example.myfirstapplication.retrofitDaggerCorutine.repository

import com.example.myfirstapplication.retrofitDaggerCorutine.dataClasses.User
import com.example.myfirstapplication.retrofitDaggerCorutine.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(): Result<List<User>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getUsers()
                Result.Success(response)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}