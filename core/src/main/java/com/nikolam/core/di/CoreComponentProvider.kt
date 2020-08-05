package com.nikolam.core.di

interface CoreComponentProvider {
    /**
     * Returns the CoreComponent / DI root.
     */
    fun provideCoreComponent(): CoreComponent
}