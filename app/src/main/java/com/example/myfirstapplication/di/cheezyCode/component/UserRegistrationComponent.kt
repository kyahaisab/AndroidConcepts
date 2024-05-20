package com.example.myfirstapplication.di.cheezyCode.component

import com.example.myfirstapplication.di.BaseDIActivity
import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import com.example.myfirstapplication.di.cheezyCode.module.NotificationServiceModule
import com.example.myfirstapplication.di.cheezyCode.module.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

// To use appComponent directly, make UserRegistrationComponent a sub component(like subclass uses super class variables)
// UserRegistrationComponent will able to use appComponent directly
@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    fun inject(baseDIActivity: BaseDIActivity)

    // Rather than using factory use builder
    @Subcomponent.Builder
    interface Builder {
        fun build(): UserRegistrationComponent
        fun retryCount(@BindsInstance retryCount: Int): Builder
    }
}