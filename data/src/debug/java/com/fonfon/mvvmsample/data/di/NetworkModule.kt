package com.fonfon.mvvmsample.data.di

import com.fonfon.mvvmsample.core.scope.PerApplication
import com.fonfon.mvvmsample.data.NETWORK_DEFAULT_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

  @Provides
  @PerApplication
  internal fun okHttpClient() = OkHttpClient.Builder()
    .connectTimeout(NETWORK_DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(NETWORK_DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(NETWORK_DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()
}
