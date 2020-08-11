package com.nikolam.dynamicgram

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class DynamicgramTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, DynamicgramApplication::class.java.name, context)
    }
}
