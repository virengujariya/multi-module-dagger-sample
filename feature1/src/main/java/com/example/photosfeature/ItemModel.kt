package com.example.photosfeature

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R2.layout.item_list)
abstract class ItemModel : EpoxyModelWithHolder<ItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var listener: View.OnClickListener

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.textViewPhoto.text = title
        holder.item.setOnClickListener(listener)
    }

    override fun unbind(holder: Holder) {
        holder.item.setOnClickListener(null)
        super.unbind(holder)
    }

    override fun shouldSaveViewState(): Boolean {
        return true
    }

    class Holder : EpoxyHolder() {
        lateinit var textViewPhoto: TextView
        lateinit var item: ConstraintLayout

        override fun bindView(itemView: View) {
            item = itemView.findViewById(R.id.item)
            textViewPhoto = itemView.findViewById(R.id.text_photo)
        }
    }
}