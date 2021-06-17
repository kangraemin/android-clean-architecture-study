package com.example.cleanarchitecture.ui.main

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.randomQuoteItem.observe(this, Observer { quoteItem ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                viewDataBinding.tvQuote.text = Html.fromHtml(quoteItem.quote, HtmlCompat.FROM_HTML_MODE_LEGACY)
            } else {
                viewDataBinding.tvQuote.text = Html.fromHtml(quoteItem.quote)
            }
        })
    }
}