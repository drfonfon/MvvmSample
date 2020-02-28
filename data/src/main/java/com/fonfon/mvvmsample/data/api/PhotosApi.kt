package com.fonfon.mvvmsample.data.api

import com.fonfon.mvvmsample.data.api.model.ApiPhoto
import io.reactivex.Single

interface PhotosApi {

    fun getPhotos(): Single<List<ApiPhoto>>
}