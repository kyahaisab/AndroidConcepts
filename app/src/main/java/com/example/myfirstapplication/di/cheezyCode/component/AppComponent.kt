package com.example.myfirstapplication.di.cheezyCode.component

import com.example.myfirstapplication.di.cheezyCode.basicFunction.AnalyticsService
import com.example.myfirstapplication.di.cheezyCode.module.AnalyticsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {

    fun getAnalyticsService(): AnalyticsService
}