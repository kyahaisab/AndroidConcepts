package com.example.myfirstapplication.di.cheezyCode.module

import com.example.myfirstapplication.di.cheezyCode.basicFunction.AnalyticsService
import com.example.myfirstapplication.di.cheezyCode.basicFunction.Mixpanel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {
    @Singleton
    @Provides
    fun getAnalyticsService(): AnalyticsService {
        return Mixpanel()
    }
}