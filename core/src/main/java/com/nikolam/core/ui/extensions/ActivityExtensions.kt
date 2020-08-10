package com.nikolam.core.ui.extensions

import android.app.Activity
import com.nikolam.core.di.CoreComponentProvider

fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")
