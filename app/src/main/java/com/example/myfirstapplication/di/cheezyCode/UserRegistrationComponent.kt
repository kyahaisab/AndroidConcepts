package com.example.myfirstapplication.di.cheezyCode

import com.example.myfirstapplication.di.BaseDIActivity
import dagger.Component

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    /*    fun getUserRegistrationService(): UserRegistrationService

        fun getEmailService(): EmailService*/

    // Suppose there are lots of objects needed by BaseDIActivity, so we can't do it 50 times as we did above.
    // So better is to let dagger know which class needs objects(i.e pass the consumer name BaseDIActivity), just pass name of that class like below
    fun inject(baseDIActivity: BaseDIActivity)
}