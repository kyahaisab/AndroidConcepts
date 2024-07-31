package com.example.myfirstapplication.workManager.retrofit

import com.example.myfirstapplication.workManager.room.SystemResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("resources")
    suspend fun sendResources(@Body resources: List<SystemResource>): Response<Unit>
}
