package com.example.myfirstapplication.retrofitDaggerCorutine.di.component

import com.example.myfirstapplication.retrofitDaggerCorutine.BaseRetrofitActivity
import com.example.myfirstapplication.retrofitDaggerCorutine.di.modules.NetworkModule
import com.example.myfirstapplication.retrofitDaggerCorutine.di.modules.RepositoryModule
import com.example.myfirstapplication.retrofitDaggerCorutine.viewModel.UserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponentOne {
    fun inject(baseRetrofitActivity: BaseRetrofitActivity)
    fun inject(userViewModel: UserViewModel)
}