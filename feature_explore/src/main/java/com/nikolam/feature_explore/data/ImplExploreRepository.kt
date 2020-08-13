package com.nikolam.feature_explore.data

import com.nikolam.feature_explore.data.model.Post
import com.nikolam.feature_explore.data.network.INetworkDataSource
import javax.inject.Inject

class ImplExploreRepository @Inject constructor(private val networkDataSource : INetworkDataSource) : IExploreRepository{

    override fun fetchPosts(): ArrayList<Post> {
        return networkDataSource.fetchPosts()
    }

}
