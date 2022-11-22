package com.vonisak.composeImageList.di.component

import com.vonisak.composeImageList.di.module.NetworkModule
import com.vonisak.composeImageList.di.module.RepositoryModule
import com.vonisak.composeImageList.di.module.ViewModelModule
import com.vonisak.composeImageList.di.viewmodelFactory.ViewModelFactory
import com.vonisak.composeImageList.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface AppComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}