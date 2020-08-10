package com.nikolam.dynamicgram

import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.CoreComponentProvider

class TestDynamicgramApplication : SplitCompatApplication(), CoreComponentProvider {
    lateinit var coreComponent: CoreComponent



    override fun provideCoreComponent(): CoreComponent = coreComponent
}
