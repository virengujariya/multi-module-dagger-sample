package com.example.photosfeature.di

import com.example.core.FeatureScope
import com.example.photosfeature.ItemActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FeatureScope
@Subcomponent
interface FeatureComponent : AndroidInjector<ItemActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ItemActivity>
}
