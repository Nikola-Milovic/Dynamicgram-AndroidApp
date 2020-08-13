package com.nikolam.feature_explore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikolam.feature_explore.data.IExploreRepository
import com.nikolam.feature_explore.data.model.Post
import javax.inject.Inject

class ExploreViewModel @Inject constructor(private val repository: IExploreRepository) : ViewModel() {
    val postListLiveData : MutableLiveData<ArrayList<Post>> = MutableLiveData()
    val _postListLiveData : LiveData<ArrayList<Post>>
        get() = postListLiveData

    init {
        makeAList()
    }

    fun makeAList(){
        val list = repository.fetchPosts()

        postListLiveData.value = list
    }
}
