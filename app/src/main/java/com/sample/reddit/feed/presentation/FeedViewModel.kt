package com.sample.reddit.feed.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.reddit.core.presentation.BaseViewModel
import com.sample.reddit.core.presentation.addTo
import com.sample.reddit.feed.domain.Feed
import com.sample.reddit.feed.domain.FeedUseCase
import com.sample.reddit.feed.domain.Post
import io.reactivex.android.schedulers.AndroidSchedulers

class FeedViewModel(feedUseCase: FeedUseCase) : BaseViewModel() {

    val posts = MutableLiveData<List<Post>>()
    var currentLimit = FEED_STARTING_LIMIT
    lateinit var feed: Feed

    init {
        feedUseCase.getFeed(SUBREDIT)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onFeedSuccess, ::onFeedError)
            .addTo(disposables)
    }

    private fun onFeedSuccess(feed: Feed) {
        this.feed = feed
        posts.value = feed.posts.take(currentLimit)
    }

    private fun onFeedError(throwable: Throwable) {
        Log.d("FeedViewModel", "Error retrieving feed.")
    }

    fun onLastPostReached() {
        currentLimit += FEED_LOAD_INCREMENT
        posts.value = feed.posts.take(currentLimit)
    }

    companion object {
        private const val SUBREDIT = "Android"
        private const val FEED_STARTING_LIMIT = 10
        private const val FEED_LOAD_INCREMENT = 5
    }

}