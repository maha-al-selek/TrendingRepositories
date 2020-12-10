package com.mahaalselek.trendingrepositories.repository

import android.util.Log
import com.mahaalselek.trendingrepositories.NetWorkApi
import com.mahaalselek.trendingrepositories.model.Item
import com.mahaalselek.trendingrepositories.model.Repository
import retrofit2.Call
import retrofit2.Response

class RepositoriesRepository (val netWorkApi: NetWorkApi) {

    fun getRepositories(onRepositoryData: OnRepositoryData) {
        netWorkApi.getRepositories().enqueue(object : retrofit2.Callback<Repository> {
            override fun onResponse(call: Call<Repository>, response: Response<Repository>) {
                if(response.isSuccessful) {
                    Log.d("mm1", response.body().toString())
                    onRepositoryData.onSuccess((response.body()))
                }else{
                    Log.d("mm1", "Failed"+response.body().toString())
                }
            }

            override fun onFailure(call: Call<Repository>, t: Throwable) {
                onRepositoryData.onFailure()
                Log.d("mm7","faileddd")
            }
        })
    }

    interface OnRepositoryData {
        fun onSuccess(data: Repository?)
        fun onFailure()
    }
}
