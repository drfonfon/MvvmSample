package com.fonfon.mvvmsample.di

import com.fonfon.mvvmsample.App
import com.fonfon.mvvmsample.core.scope.PerApplication
import com.fonfon.mvvmsample.data.di.ApiModule
import com.fonfon.mvvmsample.data.di.NetworkModule
import com.fonfon.mvvmsample.data.di.RepoModule
import com.fonfon.mvvmsample.di.module.AppModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ApiModule::class,
        RepoModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
