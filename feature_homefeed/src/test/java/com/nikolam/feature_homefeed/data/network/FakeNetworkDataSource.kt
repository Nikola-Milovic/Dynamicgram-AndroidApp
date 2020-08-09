package com.nikolam.feature_homefeed.data.network

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story

class FakeNetworkDataSource () : INetworkDataSource{

    val fakeStories = arrayListOf(Story("x"), Story("y"))

    override fun fetchStories(): ArrayList<Story> {
        return fakeStories
    }

    override fun fetchPosts(): ArrayList<Post> {
        TODO("Not yet implemented")
    }


}