package com.fonfon.mvvmsample.data.repo

import com.fonfon.mvvmsample.data.domian.Photos
import com.fonfon.mvvmsample.data.domian.resource.Resource
import io.reactivex.Observable

interface PhotoRepository {
    fun loadPhotos(): Observable<Resource<Photos>>
}