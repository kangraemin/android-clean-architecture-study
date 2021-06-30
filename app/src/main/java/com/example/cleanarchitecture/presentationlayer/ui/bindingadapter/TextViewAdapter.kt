package com.example.cleanarchitecture.presentationlayer.ui.bindingadapter

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("fromHtml")
fun TextView.fromHtml(htmlText: String?) {
    htmlText?.let {
        text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(htmlText)
        }
    }
}