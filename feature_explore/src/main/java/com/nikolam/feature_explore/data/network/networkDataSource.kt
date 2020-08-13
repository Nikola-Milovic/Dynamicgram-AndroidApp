package com.nikolam.feature_explore.data.network

import com.nikolam.feature_explore.data.model.Post

open class NetworkDataSource : INetworkDataSource {

    override fun fetchPosts() : ArrayList<Post> {
        return arrayListOf(Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"))
    }

}
