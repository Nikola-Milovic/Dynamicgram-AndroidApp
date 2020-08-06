package com.nikolam.feature_homefeed.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nikolam.core.di.vm.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.nikolam.core.di.vm.ViewModelKey
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel


@Module
abstract class HomeFeedViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeFeedViewModel::class) // PROVIDE YOUR OWN MODELS HERE
    internal abstract fun bindHomeFeedViewModel(homeFeedViewModel: HomeFeedViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}