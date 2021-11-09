package com.mahaalselek.trendingrepositories.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mahaalselek.trendingrepositories.R
import com.mahaalselek.trendingrepositories.model.Repository
import com.mahaalselek.trendingrepositories.viewmodel.RepositoryViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoryListFragment : Fragment() {

    private val repositoryListModel: RepositoryViewModel by viewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repositories_list, container, false)
    }


    override fun onStart() {
        super.onStart()

        //Hello World

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(view!!.context, LinearLayoutManager.VERTICAL, false)


        repositoryListModel.getRepositories()
         repositoryListModel.listOfRepositories.observe(this, Observer(function = fun(repositoryList: Repository?) {
             repositoryList?.let {

                 var repositoryListAdapter: RepositoryListAdapter = RepositoryListAdapter(repositoryList)
                 recyclerView.adapter = repositoryListAdapter
                     repositoryListAdapter.setItemClickListener(object : RepositoryListAdapter.ItemClickListener {
                       override fun onItemClick(view: View, position: Int) {

                        }
                    })
             }
         }))
    }


}
