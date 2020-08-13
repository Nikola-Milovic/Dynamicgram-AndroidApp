package com.nikolam.feature_homefeed.di.data

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story
import com.nikolam.feature_homefeed.data.network.INetworkDataSource

class FakeNetworkDataSource () : INetworkDataSource {

    val fakeStories = arrayListOf(Story("x"), Story("y"))

    val fakePosts = arrayListOf(Post("x","x","x","x",0, 0))


    override fun fetchStories(): ArrayList<Story> {
        return fakeStories
    }

    override fun fetchPosts(): ArrayList<Post> {
        return fakePosts
    }


}
