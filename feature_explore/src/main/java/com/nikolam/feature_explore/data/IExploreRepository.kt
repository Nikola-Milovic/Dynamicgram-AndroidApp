package com.nikolam.feature_explore.data

import com.nikolam.feature_explore.data.model.Post

interface IExploreRepository {
    fun fetchPosts() : ArrayList<Post>
}
