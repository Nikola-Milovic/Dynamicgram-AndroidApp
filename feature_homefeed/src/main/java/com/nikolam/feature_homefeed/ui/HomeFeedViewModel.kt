package com.nikolam.feature_homefeed.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikolam.feature_homefeed.data.IhomeFeedRepository
import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story
import javax.inject.Inject

class HomeFeedViewModel @Inject constructor(private val homeFeedRepository: IhomeFeedRepository): ViewModel() {
    val postListLiveData : MutableLiveData<ArrayList<Post>> = MutableLiveData()
    val _postListLiveData : LiveData<ArrayList<Post>>
        get() = postListLiveData


    val storyListLiveData : MutableLiveData<ArrayList<Story>> = MutableLiveData()
    val _storyListLiveData : LiveData<ArrayList<Story>>
        get() = storyListLiveData


    lateinit var stories : ArrayList<Story>

    fun makeAList(){
        val list = homeFeedRepository.fetchPosts()
        val list2 = homeFeedRepository.fetchStories()

        postListLiveData.value = list
        storyListLiveData.value = list2

        stories = list2
    }
}
