package com.nikolam.feature_homefeed.data

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story
import com.nikolam.feature_homefeed.data.network.NetworkDataSource

class ImplHomeFeedRepository(private val networkDataSource : NetworkDataSource) : IhomeFeedRepository{

    override fun fetchStories(): ArrayList<Story> {
        return networkDataSource.fetchStories()
    }

    override fun fetchPosts(): ArrayList<Post> {
        return networkDataSource.fetchPosts()
    }

}