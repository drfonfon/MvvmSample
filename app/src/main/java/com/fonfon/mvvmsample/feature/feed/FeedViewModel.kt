package com.fonfon.mvvmsample.feature.feed

import androidx.lifecycle.ViewModel
import com.fonfon.mvvmsample.data.domian.Photo
import com.fonfon.mvvmsample.data.domian.Photos
import com.fonfon.mvvmsample.data.domian.resource.Resource
import com.fonfon.mvvmsample.data.repo.PhotoRepo
import com.fonfon.mvvmsample.data.repo.PhotoRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class FeedViewModel @Inject constructor(photoRepo: PhotoRepository) : ViewModel() {

    private val trigger: PublishSubject<Unit> = PublishSubject.create()

    val photos: Observable<Resource<Photos>> by lazy {
        trigger.flatMap {
            photoRepo.loadPhotos()
        }
    }

    fun init() {
        trigger.onNext(Unit)
    }

    fun onPhotoClicked(photo: Photo) {
        //Навигация куда-то должна происходить внутри презентора/вьюмодели
    }

    fun onSwipeToRefesh() {
        trigger.onNext(Unit)
    }


}