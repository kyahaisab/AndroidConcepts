package com.example.myfirstapplication.di.cheezyCode.module

import com.example.myfirstapplication.di.cheezyCode.AnalyticsService
import com.example.myfirstapplication.di.cheezyCode.Mixpanel
import dagger.Module
import dagger.Provides

@Module
class AnalyticsModule {
    @Provides
    fun getAnalyticsService(): AnalyticsService {
        return Mixpanel()
    }
}