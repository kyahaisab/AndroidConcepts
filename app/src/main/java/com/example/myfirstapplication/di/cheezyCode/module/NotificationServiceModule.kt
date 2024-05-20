package com.example.myfirstapplication.di.cheezyCode.module

import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import com.example.myfirstapplication.di.cheezyCode.annotations.MessageQualifier
import com.example.myfirstapplication.di.cheezyCode.basicFunction.EmailService
import com.example.myfirstapplication.di.cheezyCode.basicFunction.MessageService
import com.example.myfirstapplication.di.cheezyCode.basicFunction.NotificationService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule() // now we have that value in component and we do not need to pass it by module
{
    @ActivityScope
    @MessageQualifier // Help to avoid type, rather than using @Named("message")
    @Provides
    fun getMessageService(): NotificationService {
        return MessageService(3)
    }

    // Say in main activity we need object of emailService as well, so dagger will get confused, as to what obj to provide
    // So there comes Named Qualifiers
    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }
}