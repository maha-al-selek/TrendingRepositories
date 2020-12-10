package com.mahaalselek.trendingrepositories


import com.mahaalselek.trendingrepositories.model.Repository
import retrofit2.Call
import retrofit2.http.GET

interface NetWorkApi{

    @GET("/search/repositories?q=created:%3E2017-10-22&sort=stars&order=desc")
    fun getRepositories(): Call<Repository>
}