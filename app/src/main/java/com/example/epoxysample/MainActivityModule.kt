package com.example.epoxysample

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(
        factory: MainActivityComponent.Factory
    ): AndroidInjector.Factory<*>

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun intentUtil() = IntentUtil()
    }
}