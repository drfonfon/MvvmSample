package com.fonfon.mvvmsample.data.di

import com.fonfon.mvvmsample.core.scope.PerApplication
import com.fonfon.mvvmsample.data.api.PhotosApi
import com.fonfon.mvvmsample.data.repo.PhotoRepo
import com.fonfon.mvvmsample.data.repo.PhotoRepository
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    @PerApplication
    internal fun photoRepo(api: PhotosApi): PhotoRepository = PhotoRepo(api)

}