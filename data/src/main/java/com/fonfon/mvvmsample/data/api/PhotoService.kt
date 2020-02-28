package com.fonfon.mvvmsample.data.api

import com.fonfon.mvvmsample.data.api.model.ApiPhoto
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun getPhotos(): Single<List<ApiPhoto>>
}