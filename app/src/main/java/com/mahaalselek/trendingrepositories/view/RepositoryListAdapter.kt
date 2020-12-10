package com.mahaalselek.trendingrepositories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahaalselek.trendingrepositories.R
import com.mahaalselek.trendingrepositories.model.Repository

class RepositoryListAdapter (private val repositoryList: Repository) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {
    private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_reposotories_list, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return repositoryList.items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.repo_name_TV?.text = repositoryList.items[position].name
        viewHolder.repo_desc_TV?.text = repositoryList.items[position].description
        val imageUrl = repositoryList.items[position].owner.avatar_url
        viewHolder.repo_owner_name_TV?.text = repositoryList.items[position].owner.login
        viewHolder.repo_starred_TV?.text = repositoryList.items[position].stargazers_count.toString()

        Glide.with(viewHolder.owner_imageView.context).load(imageUrl).into(viewHolder.owner_imageView)

        viewHolder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(viewHolder.itemView, position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repo_name_TV = itemView.findViewById<TextView>(R.id.repo_name)
        val owner_imageView = itemView.findViewById<ImageView>(R.id.owner_image)
        val repo_desc_TV = itemView.findViewById<TextView>(R.id.repo_desc)
        val repo_owner_name_TV = itemView.findViewById<TextView>(R.id.repo_owner_name)
        val repo_starred_TV = itemView.findViewById<TextView>(R.id.repo_starred)

    }


    fun setItemClickListener(clickListener: ItemClickListener) {
        onItemClickListener = clickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}