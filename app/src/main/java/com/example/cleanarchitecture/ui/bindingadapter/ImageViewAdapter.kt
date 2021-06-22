package com.example.cleanarchitecture.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("setImage")
fun ImageView.setImage(imageUrl: String?) {
    imageUrl?.let {
        Glide
            .with(this)
            .load(it)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}