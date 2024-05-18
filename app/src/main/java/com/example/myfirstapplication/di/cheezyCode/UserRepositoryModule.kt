package com.example.myfirstapplication.di.cheezyCode

import dagger.Binds
import dagger.Module
import dagger.Provides

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
    abstract fun getSQLRepository(sqlRepository: SQLRepository): UserRepository
}

