package com.sample.reddit.core.di

import com.sample.reddit.core.data.RetrofitFactory
import org.koin.dsl.module
import retrofit2.Retrofit

val coreModule = module {

    single { RetrofitFactory().retrofit }

}