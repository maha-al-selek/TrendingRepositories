package com.mahaalselek.trendingrepositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahaalselek.trendingrepositories.view.RepositoryListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, RepositoryListFragment()).commit()
    }
}
