package com.sample.reddit.feed.di

import com.sample.reddit.feed.presentation.FeedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

    viewModel { FeedViewModel() }

}