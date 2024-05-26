package com.example.myfirstapplication.retrofitDaggerCorutine.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Lazy initialization of apiService
    val apiService: ApiService by lazy {
        createRetrofitInstance().create(ApiService::class.java)
    }

    // Function to create a Retrofit instance
    private fun createRetrofitInstance(): Retrofit {
        // Create a logging interceptor for debugging purposes
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // Create a custom interceptor for error handling
        val errorInterceptor = Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)
            if (!response.isSuccessful) {
                // Handle error response here
                throw Exception("Network call failed with code: ${response.code}")
            }
            response
        }

        // Configure the OkHttpClient
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(errorInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        // Build and return the Retrofit instance
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

/*
A HttpLoggingInterceptor is configured to log request and response details for debugging.
A custom Interceptor handles error responses by checking the HTTP response code and throwing an exception for non-successful responses.
An OkHttpClient is configured with the logging and error handling interceptors, and timeout settings.


Retrofit.Builder() creates a new Retrofit builder.
baseUrl(BASE_URL) sets the base URL.
addConverterFactory(GsonConverterFactory.create()) adds a converter factory to handle JSON serialization/deserialization using Gson.
build() constructs the Retrofit instance.
create(ApiService::class.java) creates an implementation of the ApiService interface.
 */

/*
Without using lazy, other way

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val apiService: ApiService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }
}
 */