package com.fonfon.mvvmsample.data.repo

import com.fonfon.mvvmsample.data.api.PhotosApi
import com.fonfon.mvvmsample.data.api.model.ApiPhoto
import com.fonfon.mvvmsample.data.domian.Photo
import com.fonfon.mvvmsample.data.domian.Photos
import com.fonfon.mvvmsample.data.domian.resource.Resource
import com.fonfon.mvvmsample.data.domian.resource.ResourceState
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PhotoRepoTest {

    @Mock lateinit var photoApi: PhotosApi

    lateinit var photoRepo: PhotoRepo

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        photoRepo = PhotoRepo(photoApi)
    }

    @Test
    fun loadPhotos() {
        Mockito.`when`(photoApi.getPhotos())
            .thenReturn(Single.just(listOf(ApiPhoto())))

        photoRepo.loadPhotos()
            .test()
            .assertValue(Resource(ResourceState.DATA, Photos(listOf(Photo(1, "", "")))))
    }
}