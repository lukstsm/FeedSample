package com.sample.reddit.feed.data

import io.reactivex.Observable
import retrofit2.Retrofit

class FeedRepository(private val retrofit: Retrofit) {

    fun getFeed(subredit: String): Observable<Feed> {
        return retrofit.create(FeedApi::class.java)
            .getFeed(subredit)
    }

}