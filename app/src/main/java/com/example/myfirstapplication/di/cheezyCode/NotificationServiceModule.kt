package com.example.myfirstapplication.di.cheezyCode

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule {
    @MessageQualifier // Help to avoid type, rather than using @Named("message")
    @Provides
    fun getMessageService(): NotificationService {
        return MessageService()
    }

    // Say in main activity we need object of emailService as well, so dagger will get confused, as to what obj to provide
    // So there comes Named Qualifiers
    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }
}