package com.mahaalselek.trendingrepositories.model

import java.io.Serializable

data class Repository(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int




) : Serializable {
}

