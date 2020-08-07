package com.nikolam.feature_homefeed.di

import com.nikolam.core.di.ui.getViewModel
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeFeedFragmentModule(val fragment : HomeFeedFragment){

    @Provides
    fun homeFeedViewModel(): HomeFeedViewModel =
        fragment.getViewModel {
            HomeFeedViewModel()
        }

}