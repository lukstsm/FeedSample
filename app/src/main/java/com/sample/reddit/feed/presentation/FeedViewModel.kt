package com.sample.reddit.feed.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.reddit.core.presentation.BaseViewModel
import com.sample.reddit.core.presentation.addTo
import com.sample.reddit.feed.domain.Feed
import com.sample.reddit.feed.domain.FeedUseCase
import io.reactivex.android.schedulers.AndroidSchedulers

class FeedViewModel(feedUseCase: FeedUseCase) : BaseViewModel() {

    val feed = MutableLiveData<Feed>()

    init {
        feedUseCase.getFeed(SUBREDIT)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onFeedSuccess, ::onFeedError)
            .addTo(disposables)
    }

    private fun onFeedSuccess(feed: Feed) {
        this.feed.value = feed
    }

    private fun onFeedError(throwable: Throwable) {
        Log.d("FeedViewModel", "Error retrieving feed.")
    }

    fun onButtonTap() {
        Log.d("FeedViewModel", "button tapped.")
    }

    companion object {
        private const val SUBREDIT = "Android"
    }

}