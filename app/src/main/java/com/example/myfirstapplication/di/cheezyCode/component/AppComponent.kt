package com.example.myfirstapplication.di.cheezyCode.component

import com.example.myfirstapplication.di.cheezyCode.basicFunction.AnalyticsService
import com.example.myfirstapplication.di.cheezyCode.module.AnalyticsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {

    // No need to any object here when using subcomponent
    //fun getAnalyticsService(): AnalyticsService

    fun getUserRegistrationComponentFactory(): UserRegistrationComponent.Factory // This is subcomponent and AppComponent is parent component
    // So sub component will be able to use parent component
}