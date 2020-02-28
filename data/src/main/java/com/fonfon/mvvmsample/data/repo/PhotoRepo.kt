package com.fonfon.mvvmsample.data.repo

import com.fonfon.mvvmsample.core.scope.PerApplication
import com.fonfon.mvvmsample.data.api.PhotosApi
import com.fonfon.mvvmsample.data.domian.Photo
import com.fonfon.mvvmsample.data.domian.Photos
import com.fonfon.mvvmsample.data.domian.resource.Resource
import com.fonfon.mvvmsample.data.domian.resource.ResourceState
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@PerApplication
open class PhotoRepo @Inject constructor(private val photoApi: PhotosApi) : PhotoRepository {

    override fun loadPhotos(): Observable<Resource<Photos>> {
        return Observable.just(Resource(ResourceState.LOAD, data = null, error = null))
            .flatMap {
                photoApi.getPhotos()
                    .map {
                        Resource(ResourceState.DATA, data = Photos(it.map { Photo(it.id, it.title, it.url) }))
                    }
                    .onErrorReturn {
                        Resource(ResourceState.ERROR, error = it)
                    }
                    .toObservable()
            }
    }
}