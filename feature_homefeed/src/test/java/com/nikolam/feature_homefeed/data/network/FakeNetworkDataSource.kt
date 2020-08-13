package com.nikolam.feature_homefeed.data.network

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story
import com.nikolam.feature_homefeed.data.model.fakePosts
import com.nikolam.feature_homefeed.data.model.fakeStories

class FakeNetworkDataSource () : INetworkDataSource{



    override fun fetchStories(): ArrayList<Story> {
        return fakeStories
    }

    override fun fetchPosts(): ArrayList<Post> {
        return fakePosts
    }


}
