package com.nikolam.core.ui.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("loadImage")
fun AppCompatImageView.bindLoadImageImageView(url: String?) {
    url?.let {
        Glide.with(context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("loadImageCircular")
fun CircleImageView.bindLoadImage(url : String?){
    url?.let {
        Glide.with(context)
            .load(it)
            .into(this)
    }
}
