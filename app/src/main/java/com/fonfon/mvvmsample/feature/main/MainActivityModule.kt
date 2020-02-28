package com.fonfon.mvvmsample.feature.main

import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module
abstract class MainActivityModule {

  @Binds
  internal abstract fun bind(activity: MainActivity): DaggerAppCompatActivity

}