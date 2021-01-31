package com.sample.reddit.feed.di

import com.sample.reddit.feed.data.FeedRepository
import com.sample.reddit.feed.domain.FeedMapper
import com.sample.reddit.feed.domain.FeedUseCase
import com.sample.reddit.feed.presentation.FeedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

    viewModel { FeedViewModel(get()) }

    single { FeedUseCase(get(), get()) }

    single { FeedRepository(get()) }

    single { FeedMapper() }
}