package com.nikolam.dynamicgram.di

import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.ActivityScope
import com.nikolam.dynamicgram.MainActivity
import dagger.Component

@ActivityScope
// add scope, because we cannot use the same scope as the component we depend upon (CoreComponent).
@Component(
    // this feature's main/root module, it might contain submodules.
    modules = [MainActivityModule::class],
    // so we can use all objects that CoreComponent provides
    dependencies = [CoreComponent::class]
)
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}
