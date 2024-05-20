package com.example.myfirstapplication.di.cheezyCode.module

import com.example.myfirstapplication.di.cheezyCode.annotations.ActivityScope
import com.example.myfirstapplication.di.cheezyCode.basicFunction.SQLRepository
import com.example.myfirstapplication.di.cheezyCode.basicFunction.UserRepository
import dagger.Binds
import dagger.Module

/*@Module
class UserRepositoryModule {
    @Provides // as we are using inject in sqlRepo constructor, so just pass sqlRepository: SQLRepository
    fun getSQLRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }
}*/

// Another way by using binds, it need constructor injection, which sqlRepo have

@Module
abstract class UserRepositoryModule {
    @Binds // all binds uses abstract and passes param need to have constructor injection like sqlRe..
    @ActivityScope
    abstract fun getSQLRepository(sqlRepository: SQLRepository): UserRepository
}

