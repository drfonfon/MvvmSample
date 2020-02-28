package com.fonfon.mvvmsample.feature.feed

import androidx.lifecycle.ViewModel
import com.fonfon.mvvmsample.core.scope.PerFragment
import com.fonfon.mvvmsample.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FeedModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun feedFragment(): FeedFragment

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun feedViewModel(model: FeedViewModel): ViewModel
}