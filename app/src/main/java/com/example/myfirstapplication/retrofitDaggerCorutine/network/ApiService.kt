package com.example.myfirstapplication.retrofitDaggerCorutine.network

import com.example.myfirstapplication.retrofitDaggerCorutine.dataClasses.User
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}