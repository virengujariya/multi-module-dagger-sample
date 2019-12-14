package com.example.photosfeature

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R2.layout.header_view)
abstract class HeaderModel : EpoxyModelWithHolder<HeaderModel.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.textViewTitle.text = title
    }

    class Holder : EpoxyHolder() {
        lateinit var textViewTitle: TextView

        override fun bindView(itemView: View) {
            textViewTitle = itemView.findViewById(R.id.text_title)
        }
    }
}