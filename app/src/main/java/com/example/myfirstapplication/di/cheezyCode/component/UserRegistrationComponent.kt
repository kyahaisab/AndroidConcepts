package com.example.myfirstapplication.di.cheezyCode.component

import com.example.myfirstapplication.di.BaseDIActivity
import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import com.example.myfirstapplication.di.cheezyCode.module.NotificationServiceModule
import com.example.myfirstapplication.di.cheezyCode.module.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [UserRepositoryModule::class, NotificationServiceModule::class]
)
interface UserRegistrationComponent {
    fun inject(baseDIActivity: BaseDIActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance retryCount: Int,
            appComponent: AppComponent
        ): UserRegistrationComponent
    }
}