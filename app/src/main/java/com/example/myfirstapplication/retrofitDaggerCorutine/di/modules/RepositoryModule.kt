package com.example.myfirstapplication.retrofitDaggerCorutine.di.modules

import com.example.myfirstapplication.retrofitDaggerCorutine.network.ApiService
import com.example.myfirstapplication.retrofitDaggerCorutine.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }
}