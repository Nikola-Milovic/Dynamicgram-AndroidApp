package com.nikolam.feature_homefeed.data.network

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story

open class NetworkDataSource : INetworkDataSource {
    // Here we mock a networking call to some remote API to fetch stories and posts

    override fun fetchStories() : ArrayList<Story> {
        val list = ArrayList<Story>()
        for (i in 1..15){
            val story = Story(
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png")

            list.add(story)
        }
        return list
    }


    override fun fetchPosts() : ArrayList<Post> {
        val list = ArrayList<Post>()

        for (i in 1..5){
            val post = Post(
                "John $i",
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png",
                "Baboons are great",
                "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
                10,
                2
            )
            list.add(post)
        }
        return list
    }

}