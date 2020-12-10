package com.mahaalselek.trendingrepositories.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahaalselek.trendingrepositories.repository.RepositoriesRepository
import com.mahaalselek.trendingrepositories.model.Repository
import org.koin.standalone.KoinComponent

class RepositoryViewModel(val dataRepository: RepositoriesRepository) : ViewModel(), KoinComponent {

    var listOfRepositories = MutableLiveData<Repository>()

    fun getRepositories() {
        dataRepository.getRepositories(object : RepositoriesRepository.OnRepositoryData {
            override fun onSuccess(data: Repository?) {
                listOfRepositories.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}