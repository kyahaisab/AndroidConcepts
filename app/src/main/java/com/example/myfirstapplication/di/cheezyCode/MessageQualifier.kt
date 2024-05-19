package com.example.myfirstapplication.di.cheezyCode

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier // If you want to make you annotation as qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME) // It defines timeline till when it will be valid
annotation class MessageQualifier()
