package com.sample.reddit.feed.domain

import com.sample.reddit.feed.data.FeedRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class FeedUseCase(private val feedRepository: FeedRepository, private val mapper: FeedMapper) {

    fun getFeed(subredit: String): Observable<Feed> {
        return feedRepository.getFeed(subredit)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map(mapper::mapToDomain)
    }

}