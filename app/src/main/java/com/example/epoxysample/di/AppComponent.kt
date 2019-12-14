package com.example.epoxysample.di

import android.app.Application
import com.example.core.CoreComponent
import com.example.epoxysample.AppConfig
import com.example.epoxysample.MainActivityModule
import com.example.photosfeature.di.FeatureModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [
        AppModule::class,
        MainActivityModule::class,
        FeatureModule::class,
        AndroidSupportInjectionModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent : AndroidInjector<AppConfig> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): AppComponent
    }
}

