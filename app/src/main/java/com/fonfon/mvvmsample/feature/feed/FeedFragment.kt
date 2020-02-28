package com.fonfon.mvvmsample.feature.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.fonfon.mvvmsample.R
import com.fonfon.mvvmsample.data.domian.resource.ResourceState
import com.fonfon.mvvmsample.di.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_feed.error_message
import kotlinx.android.synthetic.main.fragment_feed.progress
import kotlinx.android.synthetic.main.fragment_feed.recycler
import kotlinx.android.synthetic.main.fragment_feed.swipe_to_refresh
import javax.inject.Inject

class FeedFragment : DaggerFragment() {

    @Inject lateinit var feedAdapter: FeedAdapter

    @Inject lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: FeedViewModel

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FeedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_feed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.adapter = feedAdapter
        feedAdapter.onCLick = {
            viewModel.onPhotoClicked(it)
        }

        swipe_to_refresh.setOnRefreshListener {
            swipe_to_refresh.isRefreshing = false
            viewModel.onSwipeToRefesh()
        }

        disposable = viewModel.photos
            .subscribe({
                           when (it.state) {
                               ResourceState.LOAD -> onLoad()
                               ResourceState.ERROR -> onError(it.requireError())
                               ResourceState.DATA -> {
                                   onData()
                                   feedAdapter.items.clear()
                                   feedAdapter.items.addAll(
                                       it.requireData().items
                                   )
                                   feedAdapter.notifyDataSetChanged()
                               }
                               else -> {
                                   onError(null)
                               }
                           }

                       }, { onError(it) })
        viewModel.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun onLoad() {
        progress.isVisible = true
        error_message.isVisible = false
        recycler.isVisible = false
    }

    private fun onData() {
        progress.isVisible = false
        error_message.isVisible = false
        recycler.isVisible = true
    }

    private fun onError(throwable: Throwable?) {
        progress.isVisible = false
        error_message.isVisible = true
        recycler.isVisible = false
    }

}