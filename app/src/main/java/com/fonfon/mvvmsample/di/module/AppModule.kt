package com.fonfon.mvvmsample.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.fonfon.mvvmsample.App
import com.fonfon.mvvmsample.core.scope.PerActivity
import com.fonfon.mvvmsample.di.viewmodel.ViewModelFactory
import com.fonfon.mvvmsample.feature.feed.FeedModule
import com.fonfon.mvvmsample.feature.main.MainActivity
import com.fonfon.mvvmsample.feature.main.MainActivityModule
import com.fonfon.mvvmsample.feature.splash.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: App): Context

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FeedModule::class
//            PreviewModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun splashActivity(): SplashActivity
}
