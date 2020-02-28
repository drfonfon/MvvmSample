package com.fonfon.mvvmsample.feature.feed

import com.fonfon.mvvmsample.data.domian.Photos
import com.fonfon.mvvmsample.data.domian.resource.Resource
import com.fonfon.mvvmsample.data.domian.resource.ResourceState
import com.fonfon.mvvmsample.data.repo.PhotoRepository
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class FeedViewModelTest {

    @Mock
    private lateinit var photoRepo: PhotoRepository

    @Mock
    private lateinit var consumer: Consumer<Resource<Photos>>

    private lateinit var viewModel: FeedViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = FeedViewModel(photoRepo)
    }

    @Test
    fun getPhotos() {
        `when`(photoRepo.loadPhotos())
            .thenReturn(Observable.just(Resource(ResourceState.DATA, data = Photos(), error = null)))

        viewModel.photos.subscribe(consumer)
        viewModel.init()

        verify(consumer).accept(Resource(ResourceState.DATA, data = Photos(), error = null))
    }
}