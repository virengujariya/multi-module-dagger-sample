package com.example.photosfeature

import android.view.View
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController

class ItemController(private val itemClick: (position: Int) -> Unit) :
    TypedEpoxyController<List<Item>>() {
    override fun buildModels(data: List<Item>) {
        header {
            id("header")
            title("My items")
        }

        val photoModels = mutableListOf<ItemModel_>()
        for (i in 1..100) {
            photoModels.add(
                ItemModel_()
                    .id(i)
                    .title("Carousel $i")
                    .listener(View.OnClickListener { })
            )
        }

        CarouselModel_()
            .id("carousel")
            .models(photoModels)
            .numViewsToShowOnScreen(1.5f)
            .addTo(this)

        data.forEach { item ->
            item {
                id(item.id)
                title(item.title)
                listener { _, _, _, position ->
                    itemClick.invoke(position)
                }
            }
        }
    }
}