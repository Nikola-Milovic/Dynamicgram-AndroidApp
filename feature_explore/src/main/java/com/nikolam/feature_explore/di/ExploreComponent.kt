package com.nikolam.feature_explore.di

import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.feature_explore.ui.ExploreFragment

import dagger.Component


@FragmentScope
@Component(
    modules = [ExploreModule::class],
    dependencies = [CoreComponent::class]
)
interface ExploreComponent {

    fun inject(fragment: ExploreFragment)

}
