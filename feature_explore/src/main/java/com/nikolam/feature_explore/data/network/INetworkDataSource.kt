package com.nikolam.feature_explore.data.network

import com.nikolam.feature_explore.data.model.Post

interface INetworkDataSource {
    fun fetchPosts() : ArrayList<Post>
}
