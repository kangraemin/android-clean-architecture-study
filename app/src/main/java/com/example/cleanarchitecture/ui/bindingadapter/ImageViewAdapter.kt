package com.example.cleanarchitecture.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun ImageView.setImage(imageUrl: String?) {
    imageUrl?.let {
        Glide
            .with(this)
            .load(it)
            .centerCrop()
            .into(this)
    }
}