package com.sample.reddit.ui

import android.app.Application
import com.sample.reddit.feed.di.feedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RedditApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RedditApp)
            modules(feedModule)
        }
    }
}