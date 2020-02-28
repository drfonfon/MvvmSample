package com.fonfon.mvvmsample.data.di

import com.fonfon.mvvmsample.core.scope.PerApplication
import com.fonfon.mvvmsample.data.BuildConfig
import com.fonfon.mvvmsample.data.api.PhotoApi
import com.fonfon.mvvmsample.data.api.PhotosApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @PerApplication
    internal fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @PerApplication
    internal fun apiService(retrofit: Retrofit): PhotosApi = PhotoApi(retrofit)

}