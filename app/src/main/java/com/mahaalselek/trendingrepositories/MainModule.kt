package com.mahaalselek.trendingrepositories

import com.mahaalselek.trendingrepositories.repository.RepositoriesRepository
import com.mahaalselek.trendingrepositories.viewmodel.RepositoryViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    single { RepositoriesRepository(get()) }

    single { createWebService() }

    viewModel { RepositoryViewModel(get()) }

}

fun createWebService(): NetWorkApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://api.github.com")
        .build()

    return retrofit.create(NetWorkApi::class.java)
}