package com.example.photosfeature

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_photo.*
import javax.inject.Inject

class ItemActivity : AppCompatActivity() {

    private val itemController: ItemController by lazy { ItemController(clickListener) }
    private val clickListener = { position: Int ->
        Toast.makeText(this, "Clicked $position", Toast.LENGTH_SHORT).show()
    }

    @Inject
    lateinit var photos: Lazy<List<Item>>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        recycler_view.adapter = itemController.adapter

        itemController.setData(photos.get())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        itemController.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        itemController.onRestoreInstanceState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }
}
