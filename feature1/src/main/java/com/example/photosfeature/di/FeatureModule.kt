package com.example.photosfeature.di

import com.example.photosfeature.Item
import com.example.photosfeature.ItemActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [FeatureComponent::class])
abstract class FeatureModule {
    @Binds
    @IntoMap
    @ClassKey(ItemActivity::class)
    abstract fun bindPhotoActivityInjectorFactory(
        builder: FeatureComponent.Factory
    ): AndroidInjector.Factory<*>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providePhotos(): List<Item> {
            val photos = mutableListOf<Item>()
            for (i in 1..100) {
                photos.add(Item(i, "Item $i", ""))
            }
            return photos
        }
    }
}