package com.example.epoxysample

import com.example.core.CoreComponent
import com.example.core.CoreComponentProvider
import com.example.core.DaggerCoreComponent
import com.example.epoxysample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppConfig : DaggerApplication(), CoreComponentProvider {

    private val coreComponent by lazy {
        DaggerCoreComponent.builder().build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder()
        .application(this)
        .coreComponent(provideCoreComponent())
        .build()

    override fun provideCoreComponent(): CoreComponent = coreComponent
}