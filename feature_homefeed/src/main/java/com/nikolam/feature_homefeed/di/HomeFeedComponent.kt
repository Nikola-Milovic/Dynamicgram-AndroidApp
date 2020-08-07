package com.nikolam.feature_homefeed.di

import androidx.lifecycle.ViewModel
import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Binds
import dagger.Component
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject

@FragmentScope
@Component(
    modules = [HomeFeedModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeFeedComponent {
    fun inject(fragment: HomeFeedFragment)
}