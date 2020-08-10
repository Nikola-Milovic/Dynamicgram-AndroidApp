package com.nikolam.feature_homefeed.di

import androidx.lifecycle.ViewModel
import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.HomeFeedScope
import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.network.NetworkDataSource
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Binds
import dagger.Component
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject

@HomeFeedScope
@Component(
    modules = [HomeFeedModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeFeedComponent {

    @HomeFeedScope
    fun inject(fragment: HomeFeedFragment)

}