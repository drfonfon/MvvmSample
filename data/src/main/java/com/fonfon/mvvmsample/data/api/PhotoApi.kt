package com.fonfon.mvvmsample.data.api

import com.fonfon.mvvmsample.data.api.model.ApiPhoto
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class PhotoApi(retrofit: Retrofit): PhotosApi {

    private val api = retrofit.create(PhotoService::class.java)

    override fun getPhotos(): Single<List<ApiPhoto>> = api.getPhotos()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}